package com.jiming.daily.exception.service;

import com.jiming.daily.exception.BaseRuntimeException;

/**
 * 功能：自定义运行时服务异常
 * 说明：
 * @author Mr.tjm
 * @date 2020-5-20 11:25
 */
public class ServiceException extends BaseRuntimeException {
    private static final long serialVersionUID = 4044532694254070696L;

    public ServiceException() {
    }

    public ServiceException(String errorCode, Object... obj) {
        super(errorCode, obj);
    }

    public ServiceException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public ServiceException(Throwable cause, String errorCode, Object... obj) {
        super(cause, errorCode, obj);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
