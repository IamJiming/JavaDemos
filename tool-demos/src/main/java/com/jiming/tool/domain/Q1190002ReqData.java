package com.jiming.tool.domain;

/**
 * 功能：模拟的请求数据bean
 * 说明：
 * @author Mr.tjm
 * @date 2020-5-20 11:25
 */
public class Q1190002ReqData extends PsbcReqData{
    // 预申请额度ID
    private String preAppId;
    // 客户ID
    private String cusId;

    public String getPreAppId() {
        return preAppId;
    }

    public void setPreAppId(String preAppId) {
        this.preAppId = preAppId;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Q1190002ReqData{");
        sb.append("preAppId='").append(preAppId).append('\'');
        sb.append(", cusId='").append(cusId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}