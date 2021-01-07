package com.jiming.daily.exception;

import com.jiming.daily.exception.utils.ExceptionHelper;

/**
 * 功能：自定义运行时异常 基类
 * 说明：
 * @author Mr.tjm
 * @date 2020-5-20 11:25
 */
public class BaseRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -1827091637743378043L;

    private String errorCode;
    private Object errorDetail;
    private boolean changeCode;

    public BaseRuntimeException() {
        this.changeCode = false;
    }

    public BaseRuntimeException(String code, String message, Throwable cause) {
        super(message, cause);
        this.changeCode = false;
        this.errorCode = code;
        this.changeCode = true;
    }

    public BaseRuntimeException(Throwable cause) {
        super(cause);
        this.changeCode = false;
    }

    public BaseRuntimeException(String errorCode, Object... obj) {
        super(ExceptionHelper.getExcptionInfo(errorCode, obj));
        this.changeCode = false;
        this.errorCode = errorCode;
    }

    public BaseRuntimeException(Throwable cause, String errorCode, Object... obj) {
        this(ExceptionHelper.getExcptionInfo(errorCode, obj), cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Object getErrorDetail() {
        return this.errorDetail;
    }

    public void setErrorDetail(Object errorDetail) {
        this.errorDetail = errorDetail;
    }

    public boolean isChangeCode() {
        return this.changeCode;
    }
}
