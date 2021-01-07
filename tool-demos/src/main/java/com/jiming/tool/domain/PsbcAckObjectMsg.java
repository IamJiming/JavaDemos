package com.jiming.tool.domain;

import com.jiming.tool.commons.CreMessageMap;
import com.jiming.tool.utils.JsonUtils;
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
public class PsbcAckObjectMsg {

	private String allnum;
	private String count;
	private List<LinkedHashMap<String, Object>> pageRecords = new ArrayList<LinkedHashMap<String, Object>>();
	private List<PsbcAckData> lstRecords;

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

	public List<PsbcAckData> getLstRecords(String tranCode) {

		if (lstRecords == null && pageRecords != null) {
			lstRecords = new ArrayList<PsbcAckData>();
			int iSize = pageRecords.size();
			for (int i = 0; i < iSize; i++) {
				PsbcAckData data = (PsbcAckData) JsonUtils.parseObject(JSONObject.toJSONString(pageRecords.get(i)),
						CreMessageMap.getAckMessageMap().get(tranCode));
				lstRecords.add(data);
			}
		}
		return lstRecords;
	}

	public void setLstRecords(List<PsbcAckData> lstRecords) {
		this.lstRecords = lstRecords;
	}
}
