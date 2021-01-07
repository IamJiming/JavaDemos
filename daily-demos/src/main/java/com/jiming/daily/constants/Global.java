package com.jiming.daily.constants;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 功能：全局常量
 * 说明：
 * @author Mr.tjm
 * @date 2020-5-20 11:25
 */
public class Global {

    /**
     * 是/否
     */
    public static final String YES = "1";
    public static final String NO = "0";

    /**
     * 格式
     */
    public static final String ENCODE_UTF = "UTF-8";

    /**
     * 时间管理
     */
    public static final SimpleDateFormat FORMATTER_M = new SimpleDateFormat("HHmmss");

    public static final SimpleDateFormat FORMATTER_D = new SimpleDateFormat("yyyyMMdd");

    public static final SimpleDateFormat FORMATTER_Y = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getDateFormate_M() {
        return FORMATTER_M.format(new Date());
    }

    public static String getDateFormate_D() {
        return FORMATTER_D.format(new Date());
    }

    public static String getDateFormate_Y() {
        return FORMATTER_Y.format(new Date());
    }

}
