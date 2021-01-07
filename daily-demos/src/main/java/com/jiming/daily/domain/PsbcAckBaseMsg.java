package com.jiming.daily.domain;

import com.jiming.daily.commons.CreMessageMap;
import com.jiming.daily.utils.JsonUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * 功能：tcp返回的base类
 * 说明：
 * @author Mr.tjm
 * @date 2020-5-20 11:25
 */
public class PsbcAckBaseMsg {
	//响应码
	private String code;
	//响应信息
	private String message;
	//交易流水
	private String flowno;
	//交易码
	private String tranCode;

	private PsbcAckObjectMsg pageRecords;
	
	private PsbcAckData ackData = null;

	private String object;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFlowno() {
		return flowno;
	}

	public void setFlowno(String flowno) {
		this.flowno = flowno;
	}

	public String getTranCode() {
		return tranCode;
	}

	public void setTranCode(String tranCode) {
		this.tranCode = tranCode;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public PsbcAckObjectMsg getAckListObject() {
		if(object==null||"".equals(object)|| pageRecords != null) {
			return pageRecords;
		}
		pageRecords = new PsbcAckObjectMsg();
		JSONObject obj = JSONObject.parseObject(object, Feature.OrderedField);
		pageRecords.setAllnum(obj.getString("allnum"));
		pageRecords.setCount(obj.getString("count"));
		pageRecords.setPageRecords(JSONObject.parseObject(obj.getString("pageRecords"),new ArrayList<LinkedHashMap<String,Object>>().getClass(), Feature.OrderedField));
		return pageRecords;
	}

	public void setAckListObject(PsbcAckObjectMsg ackListObject) {
		this.pageRecords = ackListObject;
	}

	public PsbcAckData getAckData() {
		if(object==null||"".equals(object)||ackData != null) {
			return ackData;
		}
		if(tranCode != null) {
			try {
				ackData = (PsbcAckData) JsonUtils.parseObject(object, CreMessageMap.getAckMessageMap().get(tranCode));
			}catch(Exception e) {
				
			}
		}
		return ackData;
	}

	public void setAckData(PsbcAckData ackData) {
		this.ackData = ackData;
	}

	public String getDoSignString() {
		if(object == null) {
			return null;
		}
		StringBuffer content = new StringBuffer();
		content.append(code);
		content.append(message);
		content.append(flowno);
		content.append(tranCode);

		if("Q1190023".equals(tranCode)) {
			
			content.append(this.getObject());
		}
		else {
			content.append(StringEscapeUtils.unescapeJava(this.getObject()));
		}
		return content.toString();
	}
}
