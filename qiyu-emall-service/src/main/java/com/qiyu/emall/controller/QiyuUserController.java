package com.qiyu.emall.controller;


import com.qiyu.emall.common.core.constants.ConstantEnum;
import com.qiyu.emall.common.core.exception.BusinessException;
import com.qiyu.emall.common.core.response.ResponseData;
import com.qiyu.emall.common.core.vo.UserAddressVo;
import com.qiyu.emall.dto.MallUserAddressDto;
import com.qiyu.emall.dto.MallUserDto;
import com.qiyu.emall.entity.QiyuUser;
import com.qiyu.emall.exception.UserException;
import com.qiyu.emall.service.QiyuUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class QiyuUserController extends BaseController {


    private Logger log = LoggerFactory.getLogger(QiyuUserController.class);

    @Autowired
    private QiyuUserService qiyuUserService;


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData registerUser(@RequestBody MallUserDto mallUserDto) {
        log.info("小程序用户注册 mallUserDto={}",mallUserDto);
        try {
            return qiyuUserService.registerUser(mallUserDto);
        } catch(BusinessException e){
            log.error("用户注册异常: code={},errMsg={}",e.getCode(),e.getMsg());
            return ResponseData.failure(e);
        }catch (Exception e) {
            log.error("用户注册异常",e);
            return ResponseData.failure(ConstantEnum.EXC_ERROR_SYSTEM);
        }
    }

    @RequestMapping(value="/getUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData getUserInfo(@RequestBody MallUserDto mallUserDto) {
        log.info("小程序获取用户信息ryMallUserDto={} ",mallUserDto);
        try {
            return qiyuUserService.getUserInfo(mallUserDto);
        } catch(BusinessException e){
            log.error("获取用户信息: code={},errMsg={}",e.getCode(),e.getMsg());
            return ResponseData.failure(e);
        }catch (Exception e) {
            log.error("获取用户信息",e);
            return ResponseData.failure(ConstantEnum.EXC_ERROR_SYSTEM);
        }
    }





    /**
     * 小程序登录
     * @param mallUserDto
     * @return
     */
    @RequestMapping(value="/login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData  mallLogin(@RequestBody MallUserDto mallUserDto){
        log.info("小程序登录" + mallUserDto.toString());
        try {
            return qiyuUserService.mallLogin(mallUserDto);
        } catch(BusinessException e){
            log.error("小程序登录业务异常: code={},errMsg={}",e.getCode(),e.getMsg());
            return ResponseData.failure(e);
        }catch (Exception e) {
            log.error("小程序登录异常",e);
            return ResponseData.failure(ConstantEnum.EXC_ERROR_SYSTEM);
        }
    }




    /**
     * 新增/修改用户地址
     * @param addressDto
     * @return
     */
    @RequestMapping("/saveAddress")
    @ResponseBody
    public ResponseData saveAddress(@RequestBody MallUserAddressDto addressDto) {
        log.info("保存用户地址信息" + addressDto.toString());
        try {

           QiyuUser qiyuUser =  qiyuUserService.getUserInfo(addressDto.getJsessionId());
            qiyuUserService.saveUserAddress(qiyuUser,addressDto);
            return ResponseData.success();
        } catch(UserException e){
            log.error("保存用户地址异常:" + e.getMessage());
            return ResponseData.failure(ConstantEnum.FIAL_USER_PARAMS_PAYMENT);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseData.failure(ConstantEnum.EXC_ERROR_SYSTEM);
        }
    }

    /**
     * 查询用户地址信息
     * @param addressDto
     * @return
     */
    @RequestMapping("/queryUserAddress")
    @ResponseBody
    public ResponseData queryUserAddress(@RequestBody MallUserAddressDto addressDto) {
        log.info("查询用户地址信息" + addressDto.toString());
        try {
            QiyuUser qiyuUser =  qiyuUserService.getUserInfo(addressDto.getJsessionId());
            List<UserAddressVo> userAddressVoList =  qiyuUserService.queryUserAddress(qiyuUser.getId());
            return ResponseData.success(userAddressVoList);
        } catch(UserException e){
            log.error("获取用户地址信息异常:" + e.getMessage());
            return ResponseData.failure(ConstantEnum.FIAL_USER_PARAMS_PAYMENT);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseData.failure(ConstantEnum.EXC_ERROR_SYSTEM);
        }
    }


}
