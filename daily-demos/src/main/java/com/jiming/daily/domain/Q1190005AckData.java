package com.jiming.daily.domain;

/**
 * 功能：模拟的返回数据bean
 * 说明：
 * @author Mr.tjm
 * @date 2020-5-20 11:25
 */
public class Q1190005AckData extends PsbcAckData {

    // 额度ID：服务方返回接口字段和数据库无法对应需要手动转化
    private String lineId;
    // 额度生效期限
    private Double linePeriod;
    // 额度生效金额
    private Double finalLineAmount;
    // 额度起始日
    private String lineBeginDate;
    // 额度终止日
    private String lineEndDate;
    // 额度申请的状态：0-处理中1-人工审批中2-已生效3-处理失败4-已失效5-已拒
    private String lineProgress;
    // 额度余额
    private Double lineBalance;

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public Double getLinePeriod() {
        return linePeriod;
    }

    public void setLinePeriod(Double linePeriod) {
        this.linePeriod = linePeriod;
    }

    public Double getFinalLineAmount() {
        return finalLineAmount;
    }

    public void setFinalLineAmount(Double finalLineAmount) {
        this.finalLineAmount = finalLineAmount;
    }

    public String getLineBeginDate() {
        return lineBeginDate;
    }

    public void setLineBeginDate(String lineBeginDate) {
        this.lineBeginDate = lineBeginDate;
    }

    public String getLineEndDate() {
        return lineEndDate;
    }

    public void setLineEndDate(String lineEndDate) {
        this.lineEndDate = lineEndDate;
    }

    public String getLineProgress() {
        return lineProgress;
    }

    public void setLineProgress(String lineProgress) {
        this.lineProgress = lineProgress;
    }

    public Double getLineBalance() {
        return lineBalance;
    }

    public void setLineBalance(Double lineBalance) {
        this.lineBalance = lineBalance;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Q1190005AckData{");
        sb.append("lineId='").append(lineId).append('\'');
        sb.append(", linePeriod=").append(linePeriod);
        sb.append(", finalLineAmount=").append(finalLineAmount);
        sb.append(", lineBeginDate='").append(lineBeginDate).append('\'');
        sb.append(", lineEndDate='").append(lineEndDate).append('\'');
        sb.append(", lineProgress='").append(lineProgress).append('\'');
        sb.append(", lineBalance=").append(lineBalance);
        sb.append('}');
        return sb.toString();
    }
}