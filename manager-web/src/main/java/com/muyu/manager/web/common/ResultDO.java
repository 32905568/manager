package com.muyu.manager.web.common;

/**
 * Created by Administrator on 2015/12/23 0023.
 */
public class ResultDO<T> {
    /**
     * 执行成功/失败
     */
    Boolean success;
    /**
     * 业务数据,对象类型
     */
    T module;
    /**
     * 错误编码 0:成功
     * @see ErrorCode
     */
    String errorCode;
    /**
     * 返回编码描述
     */
    String message;

    /**
     * 默认返回调用成功
     */
    public ResultDO(){
        this(ErrorCode.SUCCESS);
    }
    public ResultDO(ErrorCode errorCode){
        this.errorCode = errorCode.code;
        this.message = errorCode.message;
    }
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getModule() {
        return module;
    }

    public void setModule(T module) {
        this.module = module;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
