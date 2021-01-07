package com.jiming.tool.exception.utils;

import java.text.MessageFormat;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 功能：异常 工具类
 * 说明：
 * @author Mr.tjm
 * @date 2020-5-20 11:25
 */
@Component
public class ExceptionHelper {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHelper.class);

    private static Map<String, String> exceptionInfos;


    public static String getExcptionInfo(String code, Object... obj) {
        return MessageFormat.format(get(code), obj);
    }

    private static String get(String code) {
        if (exceptionInfos != null && !exceptionInfos.isEmpty()) {
            return StringUtils.isNotBlank(code) ? String.valueOf(exceptionInfos.get(code)) : code;
        } else {
            logger.error("异常配置信息加载失败,无法获取到[%s]对应的异常信息..", new Object[]{code});
            return code;
        }
    }

    @SafeVarargs
    public static <T> T getCustomExceptionBy(Exception ex, Class... customExceptionClasses) {
        for(Throwable cause = ex.getCause(); cause != null; cause = cause.getCause()) {
            Class[] var3 = customExceptionClasses;
            int var4 = customExceptionClasses.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                Class<? extends Exception> causeClass = var3[var5];
                if (causeClass.isInstance(cause)) {
                    return (T) cause;
                }
            }
        }
        return null;
    }
}
