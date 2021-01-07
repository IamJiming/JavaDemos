package com.jiming.tool.domain;

/**
 * 功能：tcp请求头
 * 说明：
 * @author Mr.tjm
 * @date 2020-5-20 11:25
 */
public class PsbcReqHead {
	// 交易日期 20180508
	private String senderDate;
	// 交易流水号 7位系统代字+10位顺序号(一天内不允许重复)
	private String flowno;
	// 交易时间 121212
	private String senderTime;
	// 系统标识 - "YCHN001"作为合作方的唯一标识，固定的
	private String sysCode = "YCHN001";

	private String tranCode;

	public String getSenderDate() {
		return senderDate;
	}

	public void setSenderDate(String senderDate) {
		this.senderDate = senderDate;
	}

	public String getFlowno() {
		return flowno;
	}

	public void setFlowno(String flowno) {
		this.flowno = flowno;
	}

	public String getSenderTime() {
		return senderTime;
	}

	public void setSenderTime(String senderTime) {
		this.senderTime = senderTime;
	}

	public String getSysCode() {
		return sysCode;
	}

	public String getTranCode() {
		return tranCode;
	}

	public void setTranCode(String tranCode) {
		this.tranCode = tranCode;
	}

	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("PsbcReqHead{");
		sb.append("senderDate='").append(senderDate).append('\'');
		sb.append(", flowno='").append(flowno).append('\'');
		sb.append(", senderTime='").append(senderTime).append('\'');
		sb.append(", sysCode='").append(sysCode).append('\'');
		sb.append(", tranCode='").append(tranCode).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
