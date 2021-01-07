package com.jiming.daily.domain;

/**
 * 功能：tcp请求头数据包
 * 说明：
 * @author Mr.tjm
 * @date 2020-5-20 11:25
 */
public class PsbcReqBaseMsg {
	PsbcReqData data;

	PsbcReqHead head;

	public PsbcReqData getData() {
		return data;
	}
	public void setData(PsbcReqData data) {
		this.data = data;
	}
	public PsbcReqHead getHead() {
		return head;
	}
	public void setHead(PsbcReqHead head) {
		this.head = head;
	}

}
