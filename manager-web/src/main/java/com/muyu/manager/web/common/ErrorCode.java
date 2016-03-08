package com.muyu.manager.web.common;

/**
 * Created by Administrator on 2015/12/23 0023.
 */
public enum ErrorCode {
    SUCCESS("SUCCESS","成功"),
    FAILED("FAILED","失败"),
    SYSTEM_ERROR("SYSTEM_ERROR","系统错误"),
    INVALID_PARAM("INVALID_PARAM","参数不合法"),
    ;
    ErrorCode(String code,String message){
        this.code = code;
        this.message = message;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String code;
    String message;

}
