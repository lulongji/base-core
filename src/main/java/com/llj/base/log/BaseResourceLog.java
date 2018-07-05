/**
 *
 */
package com.llj.base.log;


import com.llj.base.utils.server.IPAddrUtil;
import com.llj.base.utils.server.JVMUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：framework-common
 * 类名称：BaseServiceLog
 * 类描述：用于资源层 resource mc/redis/db 写日志
 * 创建人：qd
 * 创建时间：2015年12月1日 下午4:41:29
 * 修改人：qd
 * 修改时间：2015年12月1日 下午4:41:29
 * 修改备注：
 */
public class BaseResourceLog {

    public void doBeforeService(LogFoot logFoot) {
        try {
            if (LogContext.get() == null) {
                return;
                //LogContext.set(new LogContext());
            }
            Long startTimeMillis = System.currentTimeMillis(); // 记录方法开始执行的时间
            logFoot.setId(LogContext.get().getRequestId());
            logFoot.setStartTimeMillis(startTimeMillis);
            String optTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .format(startTimeMillis);
            logFoot.setOptTime(optTime);
            // step 递增
            int seqID = LogContext.get().addSequence();
            logFoot.setSequence(seqID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doAferService(LogFoot logFoot, String method, Boolean succ, Object[] arguments, Object result) {
        try {
            if (LogContext.get() == null) {
                return;
                //LogContext.set(new LogContext());
            }
            logFoot.setArguments(arguments);
            //调用的方法名
            logFoot.setMethod(method);
            logFoot.setSucc(succ);

            String JVM = JVMUtil.getJVMName();
            logFoot.setJvmname(JVM);

            String local_ip = IPAddrUtil.localAddress();
            logFoot.setLocal_ip(local_ip);

//	        String request_ip = RequestUtil.getClientIpAddress(request);
//	        logFoot.setRequest_ip(request_ip);

            Long thread = Thread.currentThread().getId();
            logFoot.setThread(thread.toString());

            // 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行
            Map<String, Object> outputParamMap = new HashMap<String, Object>();
            outputParamMap.put("result", result);
            logFoot.setOutputParamMap(outputParamMap);

            Long endTimeMillis = System.currentTimeMillis(); // 记录方法执行完成的时间
            logFoot.setEndTimeMillis(endTimeMillis);
            logFoot.doPrint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
