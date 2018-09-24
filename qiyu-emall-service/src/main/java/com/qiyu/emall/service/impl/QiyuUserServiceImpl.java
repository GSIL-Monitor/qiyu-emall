package com.qiyu.emall.service.impl;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.qiyu.emall.common.core.configer.PropertyConfigurer;
import com.qiyu.emall.common.core.constants.ConstantEnum;
import com.qiyu.emall.common.core.response.ResponseData;
import com.qiyu.emall.common.core.utils.StringUtils;
import com.qiyu.emall.common.core.vo.UserAddressVo;
import com.qiyu.emall.dto.*;
import com.qiyu.emall.entity.QiyuUser;
import com.qiyu.emall.entity.QiyuUserAcc;
import com.qiyu.emall.entity.QyUserAddress;
import com.qiyu.emall.mapper.QiyuUserAccMapper;
import com.qiyu.emall.mapper.QiyuUserMapper;
import com.qiyu.emall.mapper.QyUserAddressMapper;
import com.qiyu.emall.redis.RedisClientTemplate;
import com.qiyu.emall.service.QiyuUserService;
import com.qiyu.emall.unit.MallConfigUnit;
import com.qiyu.emall.unit.MallUserUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.*;


@Service
public class QiyuUserServiceImpl implements QiyuUserService {


    @Autowired
    private PropertyConfigurer propertyConfigurer;

    @Autowired
    private MallConfigUnit mallConfigUnit;
    @Autowired
    private MallUserUnit mallUserUnit;

    @Autowired
    private RedisClientTemplate template;
    @Autowired
    private QiyuUserMapper qiyuUserMapper;
    @Autowired
    private QyUserAddressMapper userAddressMapper;
    @Autowired
    private QiyuUserAccMapper accMapper;


    private static final int WECHAT_SESSION_TIMEOUT = 60 * 60 * 24 * 182;// session超时时间 182天

    private static final String WECHAT_SESSION = "WECHAT_SESSION_";

    private static final String MALL_OPRATOR_INFO_KEY = "MALLOPRATOR_";

    private static final int MALL_OPRATOR_SESSION_TIMEOUT = 60 * 60 * 24 * 182;// 验券小程序登录session有效期


    private Logger logger = LoggerFactory.getLogger(QiyuUserServiceImpl.class);

    @Override
    public ResponseData registerUser(MallUserDto mallUserDto) {
        //根据code获取获取openId
        String code = mallUserDto.getCode();
        try {
            if (StringUtils.isEmpty(code)) {
                return ResponseData.failure(ConstantEnum.RECON_REDIS_PARAM_ERROR);
            }

            mallConfigUnit.setClientAppId(propertyConfigurer.getProperty("client_AppId"));
            mallConfigUnit.setClienAppSecret(propertyConfigurer.getProperty("clien_AppSecret"));

            WechatOpenIdData wechatOpenIdData = mallUserUnit.getApiOpenId(code, mallConfigUnit);
            //根据sessionKey解密数据
            if (!StringUtils.isEmpty(wechatOpenIdData.getSessionKey())) {
                WechatUserData wechatUserData = mallUserUnit.getApiUserInfo(wechatOpenIdData.getSessionKey(), mallUserDto);
                //保存用户信息到db并生成jessonId，存入redis
                String jessionId = mallUserUnit.saveOrUpdateMallUser(wechatUserData);
                //将微信登录sessionKey缓存
                template.setObject(WECHAT_SESSION + jessionId, wechatOpenIdData.getSessionKey());
                template.expire(WECHAT_SESSION + jessionId, WECHAT_SESSION_TIMEOUT);
                return ResponseData.success(jessionId);
            }
        } catch (Exception e) {
            logger.error("获取注册用户信息异常:" + e);
            return ResponseData.failure(ConstantEnum.EXCEPTION_USER_REGISTER);
        }
        return ResponseData.success();
    }

    @Override
    public ResponseData getUserInfo(MallUserDto mallUserDto) {

        String jessonId = mallUserDto.getJsessionId();
        try {
            if (StringUtils.isEmpty(jessonId)) {
                return ResponseData.failure(ConstantEnum.RECON_REDIS_PARAM_ERROR);
            }
            QiyuUser qiyuUser = mallUserUnit.getUserSessionByKey(jessonId);
            if (qiyuUser == null) {
                return ResponseData.failure(ConstantEnum.EXCEPTION_USER_IDENTITY);
            }
            return ResponseData.success(ConstantEnum.EXCEPTION_USER_IDENTITY);
        } catch (Exception e) {
            logger.error("获取用户信息异常:" + e.getMessage());
            return ResponseData.failure(ConstantEnum.EXCEPTION_USER_REGISTER);
        }
    }


    @Override
    public ResponseData mallLogin(MallUserDto mallUserDto) {
        try {
            //微信授权登录
            String encryptedData = mallUserDto.getEncryptedData();
            String iv = mallUserDto.getIv();
            String code = mallUserDto.getCode();
            if (StringUtils.isEmpty(encryptedData) || StringUtils.isEmpty(iv)) {
                return ResponseData.failure(ConstantEnum.EXC_ERROR_PARAM_SYSTEM);
            }
            // WechatOpenIdData wechatOpenIdData = ryMallUserUnit.getApiOpenId(code, ryMallConfigUnit);
            String wechatKey = template.get(WECHAT_SESSION + mallUserDto.getJsessionId());
            //根据sessionKey解密数据
            if (!StringUtils.isEmpty(wechatKey)) {
                WechatPhoneData wechatPhoneData = mallUserUnit.getWechatInfo(wechatKey, mallUserDto);
                String phone = wechatPhoneData.getPurePhoneNumber();
                if (StringUtils.isEmpty(phone)) {
                    return ResponseData.failure(ConstantEnum.EXCEPTION_OPERATOR_WEPHONE_ERROR);
                }


                if (StringUtils.isEmpty(mallUserDto.getJsessionId())) {
                    return ResponseData.failure(ConstantEnum.EXC_ERROR_PARAM_SYSTEM);
                }
                QiyuUser qiyuUser = mallUserUnit.getUserSessionByKey(mallUserDto.getJsessionId());
                if (qiyuUser == null) {
                    return ResponseData.failure(ConstantEnum.EXCEPTION_USER_IDENTITY);
                }

                QiyuUser mallUser = qiyuUserMapper.queryByOpenId(qiyuUser.getOpenId());
                mallUser.setPhone(phone);
                qiyuUserMapper.updateByPrimaryKey(mallUser);

                String uuid = UUID.randomUUID().toString();
                uuid = uuid + System.currentTimeMillis();
                String tokenId = uuid;
                template.setObject(MALL_OPRATOR_INFO_KEY + tokenId, mallUser);
                template.expire(MALL_OPRATOR_INFO_KEY + tokenId, MALL_OPRATOR_SESSION_TIMEOUT);

                //开户
                QiyuUserAcc acc = accMapper.selectByUserId(qiyuUser.getId());
                if(acc == null){
                    QiyuUserAcc userAcc = new QiyuUserAcc();
                    userAcc.setUserId(qiyuUser.getId());
                    userAcc.setBalance(BigDecimal.ZERO);
                    userAcc.setFrozeBalance(BigDecimal.ZERO);
                    userAcc.setCreateAt(new Date());
                    accMapper.insert(userAcc);
                }
                return ResponseData.success(tokenId);
            }


        } catch (Exception e) {
            logger.error("登录异常:" + e.getMessage());
            return ResponseData.failure(ConstantEnum.EXCEPTION_OPERATOR_LOGIN_FAIL);

        }
        return ResponseData.failure(ConstantEnum.EXCEPTION_OPERATOR_LOGIN_FAIL);
    }


    @Override
    public QiyuUser getUserInfo(String jessonId) {
        try {
            if (StringUtils.isEmpty(jessonId)) {
                return null;
            }
            QiyuUser qiyuUser = mallUserUnit.getUserSessionByKey(jessonId);
           return qiyuUser;
        } catch (Exception e) {
            logger.error("获取用户信息异常:" + e.getMessage());
        }
        return null;
    }


    @Override
    public void saveUserAddress(QiyuUser qiyuUser, MallUserAddressDto dto) throws UnsupportedEncodingException {
        Map<String,Object> paramMap = new HashMap<>();
        QyUserAddress userAddress = new QyUserAddress();
        userAddress.setLinkName(dto.getLinkName());
        userAddress.setLinkPhone(dto.getLinkPhone());
        userAddress.setAddress(dto.getAddress());
        userAddress.setLinkSex(dto.getLinkSex().byteValue());
        userAddress.setUserId(qiyuUser.getId());
        userAddress.setLabel(dto.getLabel());
        //修改
        if(dto.getAddressId()!=null){
            //查询是否存在其他默认的地址
            paramMap.put("userId",qiyuUser.getId());
            paramMap.put("isDefault",0);
            List<QyUserAddress> userAddresses =  userAddressMapper.queryByMap(paramMap);
            QyUserAddress ryMallUserAddress = userAddresses.get(0);
            if(dto.getIsDefault() == 0 && !ryMallUserAddress.getId().equals(dto.getAddressId())){
                ryMallUserAddress.setIsDefault((byte)1);
                userAddressMapper.updateByPrimaryKeySelective(ryMallUserAddress);
            }
            userAddress.setIsDefault(dto.getIsDefault().byteValue());
            userAddress.setUpdateAt(new Date());
            userAddressMapper.updateByPrimaryKeySelective(userAddress);
        }else{
            //查询该用户下所有的地址
            paramMap.put("userId",qiyuUser.getId());
            List<QyUserAddress> userAddressList =  userAddressMapper.queryByMap(paramMap);
            if(userAddressList ==null || userAddressList.size()==0){
                userAddress.setIsDefault((byte)0);
            }else{
                userAddress.setIsDefault(dto.getIsDefault().byteValue());
                if(dto.getIsDefault() == 0){
                    for(QyUserAddress mallUserAddress :userAddressList){
                        if(mallUserAddress.getIsDefault() == 0){
                            mallUserAddress.setIsDefault((byte)1);
                            userAddressMapper.updateByPrimaryKeySelective(mallUserAddress);
                            break;
                        }
                    }
                }
            }
            userAddress.setCreateAt(new Date());
            userAddressMapper.insert(userAddress);
        }



    }

    @Override
    public List<UserAddressVo> queryUserAddress(Integer userId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userId",userId);
        List<QyUserAddress> userAddresseList = userAddressMapper.queryByMap(paramMap);
        List<UserAddressVo> userAddressVoList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(userAddresseList)){
            for(QyUserAddress address :userAddresseList){
                UserAddressVo addressVo = new UserAddressVo();
                buildAddressVo(addressVo,address);
                userAddressVoList.add(addressVo);
            }
        }
        return userAddressVoList;
    }


    private void buildAddressVo(UserAddressVo addressVo, QyUserAddress address) {
        addressVo.setAddressId(address.getId());
        addressVo.setAddress(address.getAddress());
        addressVo.setIsDefault(address.getIsDefault().intValue());
        addressVo.setLinkName(address.getLinkName());
        addressVo.setLinkPhone(address.getLinkPhone());
        addressVo.setLinkSex(address.getLinkSex().intValue());
    }
}
