/**
 *
 */
package com.llj.base.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 项目名称：framework-common
 * 类名称：RequestLogger
 * 类描述：  API层 中调用http或RPC接口 专用接口 ，记录所有http和rpc访问记录
 * 创建人：Administrator
 * 创建时间：2015年6月8日 下午3:18:00
 * 修改人：Administrator
 * 修改时间：2015年6月8日 下午3:18:00
 * 修改备注：
 */
public class APILogger {
    private static Logger log = LogManager.getLogger("API");

    private static ThreadLocal<APILogRecord> record = new ThreadLocal<APILogRecord>() {
        @Override
        protected APILogRecord initialValue() {
            return new APILogRecord();
        }
    };

    public static APILogRecord getCurrRecord() {
        return record.get();
    }

    public static void doLog() {
        APILogRecord record = getCurrRecord();
        log.info(record.print());
    }

    public static void clearCurrRecord() {
        record.remove();
    }

}
