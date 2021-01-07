package com.jiming.daily.domain;

import java.util.Date;

/**
 * 功能：存储http交互日志的Log类，根据自己的需要定义，无需过多关注
 * 说明：
 * @author Mr.tjm
 * @date 2020-5-20 11:25
 */
public class DemoLog {
    private static final long serialVersionUID = -186382526167468058L;

    private Long demoId;
    private String userId;
    private String keyId;
    private String tranceCode;
    private String encodeReq;
    private String decodeReq;
    private String encodeAck;
    private String decodeAck;
    private Date reqTime;
    private Date ackTime;
    private int doCheck;

    // 数据库相关
    public static final String TABLE = "DEMO_LOG";
    public static final String KEYS = "DEMO_ID";
    public static final String FIELDS = "DEMO_ID,USER_ID,KEY_ID,TRANCE_CODE,ENCODE_REQ,DECODE_REQ,ENCODE_ACK,DECODE_ACK,REQ_TIME,ACK_TIME,DO_CHECK";

    public Long getDemoId() {
        return demoId;
    }

    public void setDemoId(Long demoId) {
        this.demoId = demoId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getTranceCode() {
        return tranceCode;
    }

    public void setTranceCode(String tranceCode) {
        this.tranceCode = tranceCode;
    }

    public String getEncodeReq() {
        return encodeReq;
    }

    public void setEncodeReq(String encodeReq) {
        this.encodeReq = encodeReq;
    }

    public String getDecodeReq() {
        return decodeReq;
    }

    public void setDecodeReq(String decodeReq) {
        this.decodeReq = decodeReq;
    }

    public String getEncodeAck() {
        return encodeAck;
    }

    public void setEncodeAck(String encodeAck) {
        this.encodeAck = encodeAck;
    }

    public String getDecodeAck() {
        return decodeAck;
    }

    public void setDecodeAck(String decodeAck) {
        this.decodeAck = decodeAck;
    }

    public Date getReqTime() {
        return reqTime;
    }

    public void setReqTime(Date reqTime) {
        this.reqTime = reqTime;
    }

    public Date getAckTime() {
        return ackTime;
    }

    public void setAckTime(Date ackTime) {
        this.ackTime = ackTime;
    }

    public int getDoCheck() {
        return doCheck;
    }

    public void setDoCheck(int doCheck) {
        this.doCheck = doCheck;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DemoLog{");
        sb.append("demoId=").append(demoId);
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", keyId='").append(keyId).append('\'');
        sb.append(", tranceCode='").append(tranceCode).append('\'');
        sb.append(", encodeReq='").append(encodeReq).append('\'');
        sb.append(", decodeReq='").append(decodeReq).append('\'');
        sb.append(", encodeAck='").append(encodeAck).append('\'');
        sb.append(", decodeAck='").append(decodeAck).append('\'');
        sb.append(", reqTime=").append(reqTime);
        sb.append(", ackTime=").append(ackTime);
        sb.append(", doCheck=").append(doCheck);
        sb.append('}');
        return sb.toString();
    }
}
