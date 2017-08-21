package com.htf.controller.response;

import java.io.Serializable;

/**
 * Created by PC-FENG on 2017/8/21.
 */
public class ResultResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final Integer CODE = 0;

    private Integer code;

    private String msg;

    private Object result;

    public ResultResponse() {

    }

    public ResultResponse(Integer code) {
        this.code = code;
    }

    public ResultResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultResponse(Integer code, Object result) {
        this.code = code;
        this.result = result;
    }

    public ResultResponse(Object result) {
        this.result = result;
    }

    public static ResultResponse error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static ResultResponse error(String msg) {
        return error(500, msg);
    }

    public static ResultResponse error(Integer code, String msg) {
        return new ResultResponse(code, msg);
    }

    public static ResultResponse ok(String msg) {
        return new ResultResponse(CODE, msg);
    }

    public static ResultResponse ok(Object result) {
        return new ResultResponse(CODE, result);
    }

    public static ResultResponse ok() {
        return new ResultResponse(CODE);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
