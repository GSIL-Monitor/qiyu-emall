package com.qiyu.emall.common.core.log;

import com.alibaba.dubbo.rpc.RpcContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created by yujisun on 2016/4/12
 */
public class LogInterceptor extends HandlerInterceptorAdapter {

    private final static String LOG_ID = "logid";
    private final static String LOG_ID_COUNT = "logidCount";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        try {
            String logid = UUID.randomUUID().toString().substring(1, 16);
            if(!"127.0.0.1".equals(request.getRemoteAddr())) {
                logid = logid + " @ " + request.getRemoteAddr();
            }
            org.slf4j.MDC.put(LOG_ID, logid);
            org.apache.log4j.MDC.put(LOG_ID, logid);

            RpcContext.getContext().setAttachment(LOG_ID, logid);
            RpcContext.getContext().setAttachment(LOG_ID_COUNT, "1");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        org.slf4j.MDC.clear();
        org.apache.log4j.MDC.remove(LOG_ID);
        RpcContext.removeContext();
    }
}
