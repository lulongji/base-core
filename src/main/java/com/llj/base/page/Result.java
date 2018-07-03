package com.llj.base.page;

import java.io.Serializable;

/**
 * JSON返回对象
 *
 * @author lu
 */
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 状态码
     */
    private String code;

    /**
     * 信息
     */
    private String info;

    /**
     * 返回内容
     */
    private Object result;

    public static Result success() {
        Result result = new Result();
        result.setCode("200");
        result.setInfo("success");
        return result;
    }

    /**
     * @param result
     * @return
     * @desc 创建成功结果集
     */
    public static Result success(Object result) {
        Result res = new Result("200", "success");
        res.setResult(result);
        return res;
    }

    public static Result failure() {
        Result result = new Result();
        result.setCode("500");
        result.setInfo("失败");
        return result;
    }

    public static Result failure(String info) {
        Result result = failure();
        result.setInfo(info);
        return result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    /**
     * @param code
     * @param info
     * @param result
     */
    private Result(String code, String info, Object result) {
        super();
        this.code = code;
        this.info = info;
        this.result = result;
    }

    /**
     * @param code
     * @param info
     */
    private Result(String code, String info) {
        super();
        this.code = code;
        this.info = info;
    }

    /**
     *
     */
    private Result() {
        super();
    }
}
