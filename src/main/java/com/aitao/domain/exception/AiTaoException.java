package com.aitao.domain.exception;

/**
 * Created by sunyu on 2017/9/2.
 */
public class AiTaoException extends Exception{
    private static final long serialVersionUID = -6202759931123287239L;
    private static final int DEFAULT_ERROR_CODE = 201;


    /* 错误码,用于返回接口code */
    private int errCode;

    public AiTaoException(){
        super();
    }

    public AiTaoException(String msg) {
        super(msg);
        this.errCode = DEFAULT_ERROR_CODE;
    }
    public AiTaoException(int errCode, String msg) {
        super(msg);
        this.errCode = errCode;
    }

    public AiTaoException(String msg, Throwable e) {
        super(msg,e);
        this.errCode = DEFAULT_ERROR_CODE;
    }

    public AiTaoException(int errCode, String msg, Throwable e) {
        super(msg, e);
        this.errCode = errCode;
    }


    public int getErrCode() {
        return errCode;
    }
}
