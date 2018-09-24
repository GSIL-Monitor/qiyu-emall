package com.qiyu.emall.service.impl;

import com.qiyu.emall.common.core.constants.ConstantEnum;
import com.qiyu.emall.common.core.response.ResponseData;
import com.qiyu.emall.common.core.utils.StringUtils;
import com.qiyu.emall.constants.MallServiceConst;
import com.qiyu.emall.entity.QiyuCard;
import com.qiyu.emall.entity.QiyuUser;
import com.qiyu.emall.entity.QiyuUserAcc;
import com.qiyu.emall.mapper.QiyuCardMapper;
import com.qiyu.emall.mapper.QiyuUserAccMapper;
import com.qiyu.emall.mapper.QiyuUserMapper;
import com.qiyu.emall.param.UserRechargeParam;
import com.qiyu.emall.service.QiyuPayService;
import com.qiyu.emall.service.QiyuUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class QiyuPayServiceImpl implements QiyuPayService {

    @Autowired
    private QiyuUserMapper userMapper;

    @Autowired
    private QiyuUserAccMapper userAccMapper;

    @Autowired
    private QiyuCardMapper cardMapper;

    @Autowired
    private QiyuUserService userService;
    private Logger logger  = LoggerFactory.getLogger(this.getClass());
    @Override
    @Transactional
    public ResponseData rechargeByCard(UserRechargeParam rechargeParam) {
        logger.info("用户存储卡充值 rechargeParam={}",rechargeParam);
        String cardNo = rechargeParam.getCardNo();
        String cardPwd = rechargeParam.getCardPwd();
        String jessionId = rechargeParam.getJessionId();
        if(StringUtils.isEmpty(jessionId) ||StringUtils.isEmpty(cardNo) || StringUtils.isEmpty(cardPwd)){
           return ResponseData.failure(ConstantEnum.EXC_ERROR_PARAM_SYSTEM);
        }
        QiyuUser qiyuUser = userService.getUserInfo(jessionId);
        if(qiyuUser == null){
            return ResponseData.failure(ConstantEnum.FIAL_USER_PARAMS_PAYMENT);
        }
        QiyuCard card = cardMapper.selectByNoPwd(cardNo,cardPwd);

        if(card == null){
            return ResponseData.failure(ConstantEnum.PAY_CARD_INFO_ERROR);
        }

        Date beginTime = card.getValidBegin();
        Date endTime = card.getValidEnd();
        Date now = new Date();
        if(!(beginTime.compareTo(now)<=0 && endTime.compareTo(now)>=0)){
            return ResponseData.failure(ConstantEnum.PAY_CARD_INVALID);

        }

        if(MallServiceConst.CARD_USED ==card.getStatus()){
            return ResponseData.failure(ConstantEnum.PAY_CARD_INVALID_USED);
        }
        if(MallServiceConst.CARD_INVALID ==card.getStatus()){
            return ResponseData.failure(ConstantEnum.PAY_CARD_INVALID_TIMEOUT);
        }

        QiyuUserAcc userAcc = userAccMapper.selectByUserId(qiyuUser.getId());
        if(userAcc == null){
            return ResponseData.failure(ConstantEnum.PAY_CARD_FIND_ACC_ERROR);

        }
        //更新卡状态
        card.setStatus(MallServiceConst.CARD_USED);
        card.setUserId(userAcc.getUserId());
        cardMapper.updateByPrimaryKey(card);

        //修改用户账户余额
        BigDecimal balance = userAcc.getBalance();
        userAcc.setBalance(balance.add(card.getAmount()));
        userAccMapper.updateByPrimaryKey(userAcc);


        return ResponseData.success();
    }
}
