package com.qiyu.emall.common.core.response;

import com.qiyu.emall.common.core.constants.BusinessExceptionEnum;
import com.qiyu.emall.common.core.exception.BusinessException;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      2017/7/13 下午6:35
 * Description:
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2017/7/13      ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class ResponseDataUtils {
    private static final Meta SUCCESS = new Meta("0", "success"); //成功
    private static final Meta FAILURE = new Meta("1", "failure"); //失败

    private ResponseDataUtils() {

    }

    /**
     * 成功返回值对象
     *
     * @return ResponseData
     */
    public static ResponseData success() {
        return new ResponseData(ResponseDataUtils.SUCCESS);
    }

    /**
     * 成功返回值对象
     *
     * @param data 返回的数据
     * @return ResponseData
     */
    public static <T> ResponseData success(T data) {
        return new ResponseData<>(ResponseDataUtils.SUCCESS, data);
    }

    /**
     * 分页成功返回值对象
     *
     * @param data        数据
     * @param currentPage 当前页
     * @param pageSize    每页大小
     * @param totalCount  总行数
     * @return ResponseData
     */
    public static <T> ResponseData success(T data, Integer currentPage, Integer pageSize, Integer totalCount) {
        return new ResponseData<>(ResponseDataUtils.SUCCESS, data, currentPage, pageSize, totalCount);
    }

    /**
     * 分页成功返回值对象
     *
     * @param data 数据
     * @param page 分页数据
     * @return ResponseData
     */
    public static <T> ResponseData success(T data, Page page) {
        return new ResponseData<>(ResponseDataUtils.SUCCESS, data, page);
    }

    /**
     * 失败返回值对象
     *
     * @return ResponseData
     */
    public static ResponseData failure() {
        return new ResponseData<>(ResponseDataUtils.FAILURE);
    }

    /**
     * 失败返回值对象
     *
     * @param e 异常信息
     * @return ResponseData
     */
    public static ResponseData failure(BusinessException e) {
        return new ResponseData<>(new Meta(e.getCode(), e.getMessage()));
    }

    /**
     * 失败返回值对象
     *
     * @return ResponseData
     */
    public static ResponseData failure(BusinessExceptionEnum constantEnum) {
        return failure(new BusinessException(constantEnum));
    }

    /**
     * 失败码/失败信息回值对象
     *
     * @param code 错误码
     * @param msg  错误消息
     * @return ResponseData
     */
    public static ResponseData failure(String code, String msg) {
        return new ResponseData(new Meta(code, msg));
    }

    /**
     * 失败返回值对象
     *
     * @param e 异常信息
     * @return ResponseData
     */
    public static  <T> ResponseData failureResult(T data,BusinessExceptionEnum e) {
        return new ResponseData<>(new Meta(e.getCode().toString(), e.getValue().toString()),data);
    }

    public static void main(String[] args) {
        System.out.println(ResponseDataUtils.success().toJson());
        System.out.println(ResponseDataUtils.success("处理成功：返回单个对象").toJson());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("测试数据" + i);
        }
        System.out.println(ResponseDataUtils.success(list, 1, 10, 200).toJson());
        System.out.println(ResponseDataUtils.success(list, new Page(1, 10, 20)).toJson());
        System.out.println(ResponseDataUtils.failure().toJson());
        System.out.println(ResponseDataUtils.failure("1020001", "业务出错").toJson());
        System.out.println(ResponseDataUtils.failure(BusinessExceptionEnum.EXCEPTION_USER_IDENTITY).toJson());
    }
}
