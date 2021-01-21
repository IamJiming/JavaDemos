package com.jiming.daily.commons;

import com.jiming.daily.business.domain.Q6250002AckData;
import com.jiming.daily.business.domain.Q6250002ReqData;
import com.jiming.daily.business.domain.Q6250005AckData;
import com.jiming.daily.business.domain.Q6250005ReqData;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能：验证请求与相应的合法性
 * 说明：这里只暂时演示2个
 * @author Mr.tjm
 * @date 2020-5-20 11:45
 */
public class MessageMap {

	/**
	 * 把所有的合法请求预加进来
	 * @return
	 */
	public static Map<Class<?>,String> getReqMessageMap(){
		Map<Class<?>,String> map = new HashMap<Class<?>,String>();
		map.put(Q6250002ReqData.class,"Q6250002");
		map.put(Q6250005ReqData.class,"Q6250005");
		return map;
	}

	/**
	 * 把所有的合法响应预加进来
	 * @return
	 */
	public static Map<String,Class<?>> getAckMessageMap(){
		Map<String,Class<?>> map = new HashMap<String,Class<?>>();
		map.put("Q6250002", Q6250002AckData.class);
		map.put("Q6250005", Q6250005AckData.class);
		return map;
	}
}
