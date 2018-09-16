package com.qiyu.emall.unit;

import com.qiyu.emall.common.core.configer.PropertyConfigurer;
import com.qiyu.emall.common.core.constants.BusinessExceptionEnum;
import com.qiyu.emall.common.core.exception.BusinessException;
import com.qiyu.emall.common.core.utils.Util;
import com.qiyu.emall.dto.MallUserDto;
import com.qiyu.emall.dto.WechatOpenIdData;
import com.qiyu.emall.dto.WechatPhoneData;
import com.qiyu.emall.dto.WechatUserData;
import com.qiyu.emall.entity.QiyuUser;
import com.qiyu.emall.mapper.QiyuUserMapper;
import com.qiyu.emall.redis.RedisClientTemplate;
import com.qiyu.emall.utils.AES128Util;
import com.qiyu.emall.utils.HttpClientUtil;
import net.sf.json.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.net.URLDecoder;
import java.text.MessageFormat;
import java.util.Date;
import java.util.UUID;

@Repository
public class MallUserUnit {

    private static final Logger log = LoggerFactory.getLogger(MallUserUnit.class);
    private static final String MALL_USER_INFO_KEY = "MALLUSER_";

    private static final int POS_USER_USER_SESSION_TIMEOUT = 60 * 60 * 24 * 182;// session超时时间 182天

    @Autowired
    private QiyuUserMapper qiyuUserMapper;
    @Autowired
    private PropertyConfigurer propertyConfigurer;

    @Autowired
    private RedisClientTemplate template;

    public WechatOpenIdData getApiOpenId(String code, MallConfigUnit mallConfigUnit) {
        log.info("getApiOpenId code=" + code);
        try {
            String openIdUrl = propertyConfigurer.getProperty("wechat.openId.uri");
            String reqUrl = MessageFormat.format(openIdUrl, mallConfigUnit.getClientAppId(), mallConfigUnit.getClienAppSecret(), code);

            String result = HttpClientUtil.getHttpResult(reqUrl);
            log.info("getApiOpenId result={}", result);
            return (WechatOpenIdData) Util.getObjectFromString(result, WechatOpenIdData.class);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("getApiOpenId异常:", e);
            throw new BusinessException(BusinessExceptionEnum.EXCEPTION_USER_WE_CHAT);
        }
    }

    /**
     * 获取用户基本信息
     *
     * @param mallUserDto 用户dto
     * @param sessionKey    接口sessionKey
     */
    public WechatUserData getApiUserInfo(String sessionKey, MallUserDto mallUserDto) {
        log.info("getApiUserInfo RyMallUserDto={}，sessionKey={}", mallUserDto.toJson(), sessionKey);
        try {
            if (StringUtils.isNotEmpty(mallUserDto.getEncryptedData()) && StringUtils.isNotEmpty(mallUserDto.getIv())) {
                String encrytedDate = URLDecoder.decode(mallUserDto.getEncryptedData(), "UTF-8");
                String iv = URLDecoder.decode(mallUserDto.getIv(), "UTF-8");
                String userInfo = AES128Util.wxDecrypt(encrytedDate, sessionKey, iv);
                log.info("getApiUserInfo result={}", userInfo);
                return (WechatUserData) Util.getObjectFromString(userInfo, WechatUserData.class);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("getApiUserInfo异常:", e);
            throw new BusinessException(BusinessExceptionEnum.EXCEPTION_USER_WE_CHAT);
        }

    }

    /**
     * 获取微信绑定手机号
     *
     * @param mallUserDto 用户dto
     * @param sessionKey    接口sessionKey
     */
    public WechatPhoneData getWechatInfo(String sessionKey, MallUserDto mallUserDto) {
        log.info("获取微信绑定手机号 RyMallUserDto={}，sessionKey={}", mallUserDto.toJson(), sessionKey);
        try {
            if (StringUtils.isNotEmpty(mallUserDto.getEncryptedData()) && StringUtils.isNotEmpty(mallUserDto.getIv())) {
                String encrytedDate = URLDecoder.decode(mallUserDto.getEncryptedData(), "UTF-8");
                String iv = URLDecoder.decode(mallUserDto.getIv(), "UTF-8");
                String phoneInfo = AES128Util.wxDecrypt(encrytedDate, sessionKey, iv);
                log.info("获取微信授权用户绑定手机号 result={}", phoneInfo);
                return (WechatPhoneData) Util.getObjectFromString(phoneInfo, WechatPhoneData.class);
            } else {
                throw new BusinessException(BusinessExceptionEnum.EXCEPTION_USER_WE_CHAT);
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("getApiUserInfo异常:", e);
            throw new BusinessException(BusinessExceptionEnum.EXCEPTION_USER_WE_CHAT);
        }

    }

    /**
     * 保存微信登录用户数据
     *
     * @param wechatUserData 微信登录用户数据
     * @return jSessionId 用户登录凭证
     */
    public String saveOrUpdateMallUser(WechatUserData wechatUserData) {
        String jSessionId = "";
        try {
            QiyuUser qiyuUser = qiyuUserMapper.queryByOpenId(wechatUserData.getOpenId());
            if (qiyuUser == null) {
                qiyuUser = new QiyuUser();
            }

            if (StringUtils.isNotEmpty(wechatUserData.getNickName())) {
                String nickName = Base64.encodeBase64String(wechatUserData.getNickName().getBytes("utf-8"));
                qiyuUser.setUserName(nickName);
            }
            qiyuUser.setAvatar(wechatUserData.getAvatarUrl());
            qiyuUser.setCity(wechatUserData.getCity());
            qiyuUser.setOpenId(wechatUserData.getOpenId());
            qiyuUser.setProvince(wechatUserData.getProvince());
            qiyuUser.setRegisterAt(new Date());
            qiyuUser.setSource(new Byte("0"));
            qiyuUser.setStatus(new Byte("1"));
            if (qiyuUser.getId() == null) {
                qiyuUserMapper.insertSelective(qiyuUser);
            } else {
                qiyuUserMapper.updateByPrimaryKey(qiyuUser);
            }
            String uuid = UUID.randomUUID().toString();
            uuid = uuid + System.currentTimeMillis();
            jSessionId = uuid;
            template.setObject(MALL_USER_INFO_KEY + jSessionId, qiyuUser);
            template.expire(MALL_USER_INFO_KEY + jSessionId, POS_USER_USER_SESSION_TIMEOUT);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("saveMallUser异常:", e);
        }
        return jSessionId;
    }

    /**
     * 获取用户登录 信息
     *
     * @param key jsessionid
     * @return UserVo
     */
    public QiyuUser getUserSessionByKey(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        QiyuUser qiyuUser = null;
        int temp = 0;//重试次数
        try {
            while (temp < 4) {
                try {
                    temp++;
                    String userKey = template.get(MALL_USER_INFO_KEY + key);
                    if (StringUtils.isNotBlank(userKey)) {
                        qiyuUser = (QiyuUser) JSONObject.toBean(JSONObject.fromObject(userKey), QiyuUser.class);
                        qiyuUser.setSignName(qiyuUser.getUserName());
                        if (qiyuUser != null) {
                            String nickname = new String(Base64.decodeBase64(qiyuUser.getUserName().getBytes()), "utf-8");
                            qiyuUser.setUserName(nickname);
                        }
                        log.info("ryMallUser={}", qiyuUser);
                    }
                    break;
                } catch (Exception r) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        log.error("获取用户信息发生异常", e);
                    }
                    log.error("获取用户信息发生异常 RpcException= RetryNum" + temp, r);
                }
            }
        } catch (Exception e) {
            log.error("获取用户信息发生异常===", e);
            e.printStackTrace();
        }

        return qiyuUser;
    }



}
