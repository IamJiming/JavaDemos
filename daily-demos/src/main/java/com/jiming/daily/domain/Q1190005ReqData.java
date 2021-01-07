package com.jiming.daily.domain;

/**
 * 功能：模拟的请求数据bean
 * 说明：
 * @author Mr.tjm
 * @date 2020-5-20 11:25
 */
public class Q1190005ReqData extends PsbcReqData{
    // 额度ID
    private String lineId;
    // 额度订单号：合作方生成，7位系统代字+8位日期+02+8位顺序号
    private String lineAppId;

    public String getLineAppId() {
        return lineAppId;
    }

    public void setLineAppId(String lineAppId) {
        this.lineAppId = lineAppId;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Q1190005ReqData{");
        sb.append("lineId='").append(lineId).append('\'');
        sb.append(", lineAppId='").append(lineAppId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}