package com.qiyu.emall.common.core.log;

import com.alibaba.dubbo.rpc.RpcContext;
import org.apache.commons.lang.StringUtils;

import java.util.UUID;

public class LogAopAdvice {
    private final static String LOG_ID = "logid";
    private final static String LOG_ID_COUNT = "logidCount";

    public void logIdInit() {
        String logId = RpcContext.getContext().getAttachment(LOG_ID);

        if (StringUtils.isBlank(logId)) {
            logId = UUID.randomUUID().toString().substring(1, 16);
        }
        String localHost = RpcContext.getContext().getLocalHost();
        if (StringUtils.isNotBlank(localHost)) {
            if (!logId.endsWith(localHost)) {
                logId = logId + " @ " + localHost;
            }
        }
        org.slf4j.MDC.put(LOG_ID, logId);
        org.apache.log4j.MDC.put(LOG_ID, logId);

        //aop多次切入，计数，只有最后一次会清楚mdc的logid
        if (getLoginCount() != null) {
            Integer logIdCount = Integer.parseInt(getLoginCount()) + 1;
            RpcContext.getContext().setAttachment(LOG_ID_COUNT, String.valueOf(logIdCount));
        } else {
            RpcContext.getContext().setAttachment(LOG_ID_COUNT, "1");
        }

        RpcContext.getContext().setAttachment(LOG_ID, logId);
    }

    public void clear() {
        if (getLoginCount() == null) {
            RpcContext.removeContext();
            org.slf4j.MDC.clear();
            org.apache.log4j.MDC.remove(LOG_ID);
        } else {
            Integer logIdCount = Integer.parseInt(getLoginCount()) - 1;
            if (logIdCount == 0) {
                RpcContext.removeContext();
                org.slf4j.MDC.clear();
                org.apache.log4j.MDC.remove(LOG_ID);
            } else {
                RpcContext.getContext().setAttachment(LOG_ID_COUNT, String.valueOf(logIdCount));
            }
        }
    }

    public void exceptionProcess() {
//        if (getLoginCount() == null) {
//            RpcContext.removeContext();
//            org.slf4j.MDC.clear();
//            org.apache.log4j.MDC.remove(LOG_ID);
//        } else {
//            Integer logIdCount = Integer.parseInt(getLoginCount()) - 1;
//            if (logIdCount == 0) {
//                RpcContext.removeContext();
//                org.slf4j.MDC.clear();
//                org.apache.log4j.MDC.remove(LOG_ID);
//            } else {
//                RpcContext.getContext().setAttachment(LOG_ID_COUNT, String.valueOf(logIdCount));
//            }
//        }
        clear();
    }

    /**
     * 获取logid_count
     *
     * @return
     */
    private String getLoginCount() {
        return RpcContext.getContext().getAttachment(LOG_ID_COUNT);
    }
}
