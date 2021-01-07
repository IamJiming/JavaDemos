package com.jiming.tool.utils;

import com.jiming.tool.constants.ParamInDBConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 功能：这些常量，以后需要存储在数据库，便于动态获取
 * 说明：这里为了代码讲述的简介，所以没有维护DB
 * @author Mr.tjm
 * @date 2020-5-20 11:25
 */
@Service
public class ParamInDB {
    private static final Logger logger = LoggerFactory.getLogger(ParamInDB.class);

    // 服务方URL
    private String psbcConnectUrl;

    /**
     * “服务方公钥”与“合作方私钥”是一对
     */
    // 服务方公钥（与“合作方私钥”是一对）
    private String servicePublicKey;
    // 合作方私钥
    private String servicePrivateKey;

    /**
     * “合作方公钥”与“服务方私钥”是一对
     */
    // 合作方公钥（与“服务方私钥”是一对）
    private String workPrivateKey;
    // 服务方私钥
    private String workPublicKey;

    public String getPsbcConnectUrl() {
        return this.getParaMapByKey(ParamInDBConstant.psbcConnectUrl);
    }

    public String getServicePublicKey() {
        return this.getParaMapByKey(ParamInDBConstant.servicePublicKey);
    }

    public String getServicePrivateKey() {
        return this.getParaMapByKey(ParamInDBConstant.servicePrivateKey);
    }

    public String getWorkPrivateKey() {
        return this.getParaMapByKey(ParamInDBConstant.workPrivateKey);
    }

    public String getWorkPublicKey() {
        return this.getParaMapByKey(ParamInDBConstant.workPublicKey);
    }

    /**
     * 根据数据字典名，返回数据字典数据列表
     * 这里需要补充一个调用DB的方法，方便起见，直接定义在常量里，直接返回
     * 小伙伴自行脑补吧！！
     */
    private String getParaMapByKey(String paraKey) {
        logger.debug("获取字典参数【%s】", paraKey);
        // 就是这里，补充一个Dao方法
        String paraValue = paraKey;
        if (paraValue.isEmpty()) {
            logger.error("调用公共中心数据字典服务无返回值，【%s】", paraKey);
        }
        return paraValue;
    }
}
