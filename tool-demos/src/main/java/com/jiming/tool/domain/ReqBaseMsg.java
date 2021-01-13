package com.jiming.tool.domain;

/**
 * 功能：tcp请求头数据包
 * 说明：
 * @author Mr.tjm
 * @date 2020-5-20 11:25
 */
public class ReqBaseMsg {
	ReqData data;

	ReqHead head;

	public ReqData getData() {
		return data;
	}
	public void setData(ReqData data) {
		this.data = data;
	}
	public ReqHead getHead() {
		return head;
	}
	public void setHead(ReqHead head) {
		this.head = head;
	}

}
