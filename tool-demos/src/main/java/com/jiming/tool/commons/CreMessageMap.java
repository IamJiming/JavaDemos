package com.jiming.tool.commons;

import com.jiming.tool.domain.Q1190002AckData;
import com.jiming.tool.domain.Q1190002ReqData;
import com.jiming.tool.domain.Q1190005AckData;
import com.jiming.tool.domain.Q1190005ReqData;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能：验证请求与相应的合法性
 * 说明：这里只暂时演示2个
 * @author Mr.tjm
 * @date 2020-5-20 11:25
 */
public class CreMessageMap {

	/**
	 * 把所有的合法请求预加进来
	 * @return
	 */
	public static Map<Class<?>,String> getReqMessageMap(){
		Map<Class<?>,String> map = new HashMap<Class<?>,String>();
		map.put(Q1190002ReqData.class,"Q1190002");
		map.put(Q1190005ReqData.class,"Q1190005");
		return map;
	}

	/**
	 * 把所有的合法响应预加进来
	 * @return
	 */
	public static Map<String,Class<?>> getAckMessageMap(){
		Map<String,Class<?>> map = new HashMap<String,Class<?>>();
		map.put("Q1190002", Q1190002AckData.class);
		map.put("Q1190005", Q1190005AckData.class);
		return map;
	}
}
