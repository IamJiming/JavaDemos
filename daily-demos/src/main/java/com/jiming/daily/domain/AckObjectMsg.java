package com.jiming.daily.domain;

import com.jiming.daily.commons.MessageMap;
import com.jiming.daily.utils.JsonUtils;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 功能：tcp返回的数据base类
 * 说明：
 * @author Mr.tjm
 * @date 2020-5-20 11:25
 */
public class AckObjectMsg {

	private String allnum;
	private String count;
	private List<LinkedHashMap<String, Object>> pageRecords = new ArrayList<LinkedHashMap<String, Object>>();
	private List<AckData> lstRecords;

	public String getAllnum() {
		return allnum;
	}

	public void setAllnum(String allnum) {
		this.allnum = allnum;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public List<LinkedHashMap<String, Object>> getPageRecords() {
		return pageRecords;
	}

	public void setPageRecords(List<LinkedHashMap<String, Object>> pageRecords) {
		this.pageRecords = pageRecords;
	}

	public List<AckData> getLstRecords(String tranCode) {

		if (lstRecords == null && pageRecords != null) {
			lstRecords = new ArrayList<AckData>();
			int iSize = pageRecords.size();
			for (int i = 0; i < iSize; i++) {
				AckData data = (AckData) JsonUtils.parseObject(JSONObject.toJSONString(pageRecords.get(i)),
						MessageMap.getAckMessageMap().get(tranCode));
				lstRecords.add(data);
			}
		}
		return lstRecords;
	}

	public void setLstRecords(List<AckData> lstRecords) {
		this.lstRecords = lstRecords;
	}
}
