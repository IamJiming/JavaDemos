package com.jiming.daily.commons;

import com.jiming.daily.constants.Global;
import com.jiming.daily.domain.*;
import com.jiming.daily.exception.service.ServiceException;
import com.jiming.daily.utils.*;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;

import javax.net.ssl.SSLException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.security.PublicKey;
import java.util.Date;

/**
 * 功能：发送数据（加密和解密都在此处）
 * 说明：
 * @author Mr.tjm
 * @date 2020-5-20 11:25
 */
@Service
public class CrePsbcClient {
    private static final Logger logger = LoggerFactory.getLogger(CrePsbcClient.class);

    // http 客户端工厂所需参数
	private int maxTotalConnect = 100;      // 连接池的最大连接数，默认为0
	private int maxConnectPerRoute = 100;   // 单个主机的最大连接数
	private int connectTimeout = 150000;    // 连接超时默认
	private int readTimeout = 900000;       // 读取超时默认

    // 需要动态配置的参数
    @Autowired
    private ParamInDB dBparam;

    /**
     * 发送数据
     * @param data
     * @param userId
     * @return
     */
    public PsbcAckBaseMsg sendData(PsbcReqData data, String userId) {
        PsbcAckBaseMsg ackMsg = new PsbcAckBaseMsg();
        DemoLog psbcLog = new DemoLog();

        // 请求合法性验证
        String tranCode = CreMessageMap.getReqMessageMap().get(data.getClass());
        logger.info("上送前请求code：" + tranCode);

        // 数据加密
        logger.info("上送加密前data:" + JsonUtils.parseObject(data));
        String sendData = this.getSignSendData(data, psbcLog);
        logger.info("上送加密后data:" + sendData);

        // 维护日志信息
        psbcLog.setEncodeReq(sendData);
        psbcLog.setUserId(userId);
        psbcLog.setReqTime(new Date());

        // 获取请求地址
        String callUrl = this.getCallUrl(data.getClass());
        logger.info("请求地址：" + callUrl);

        if(StringUtils.isBlank(sendData) || StringUtils.isBlank(callUrl)) {
            ackMsg.setCode("02");
            ackMsg.setMessage("程序内部错误！！！");
            logger.info("程序内部错误！！！");
            throw new ServiceException("程序内部错误！");
        }

        // 发送请求，接收返回数据
        PsbcReq2AckMsg psbcMsg = null;
        try {
            String retMSg = this.callUrl(callUrl, sendData);
            logger.info("服务端返回的结果是 = " + retMSg);

            // 补全日志信息
            psbcLog.setAckTime(new Date());
            psbcLog.setEncodeAck(retMSg);

            // 解析返回数据
            if (StringUtils.isBlank(retMSg)) {
                ackMsg.setCode("01");
                ackMsg.setMessage("未正确返回报文");
            } else {
                psbcMsg = JsonUtils.parseObject(retMSg, PsbcReq2AckMsg.class);
            }

            if (psbcMsg == null) {
                ackMsg.setCode("01");
                ackMsg.setMessage("非法报文!!!");
            } else {
                ackMsg = this.getDecodeResponseData(psbcMsg, psbcLog);
            }
        } catch (Exception e) {
            logger.error("接口发送异常：" + JsonUtils.parseObject(e));
        }

        // 异步向数据库写日志——psbcLog（略），如：MQ
        logger.info("当前日志信息：" + JsonUtils.parseObject(psbcLog));
        logger.info("发送日志结果：" + "成功");
        return ackMsg;
    }

    /**
     * 获取请求http地址
     * @param clazz
     * @return
     */
    private String getCallUrl(Class<?> clazz) {
        if (!CreMessageMap.getReqMessageMap().containsKey(clazz)) {
            logger.error("没有预设的类！");
            return "";
        }
        String sysCode = CreMessageMap.getReqMessageMap().get(clazz);
        String url = dBparam.getPsbcConnectUrl();
        return String.format(url, sysCode);
    }

    /**
     * 发送请求
     * @param callUrl
     * @param data
     * @return
     */
	public String callUrl(String callUrl, String data) {
		long start = System.currentTimeMillis();
		try {
			 String result = HttpClientUtils.doPost(callUrl, data);
			logger.info("请求耗时：%s----------" + callUrl, (System.currentTimeMillis() - start) + "ms");
			if (StringUtils.isNotEmpty(result)) {
				return result;
			}
		} catch (Exception e) {
			logger.error("请求耗时：%s----------" + callUrl, (System.currentTimeMillis() - start) + "ms");
			logger.error("银行请求异常：%s ------- " + callUrl, JSON.toJSONString(e));
		}
		return "";
	}

	/**
	 * 组装加密请求
	 * @param Obj
	 * @param psbcLog
	 * @return
	 */
	public  String getSignSendData(PsbcReqData Obj, DemoLog psbcLog) {
	    // 请求合法性判定
        String tranCode = CreMessageMap.getReqMessageMap().get(Obj.getClass());
		if(StringUtils.isBlank(tranCode)) {
			logger.info("没有预设的类！");
			return "";
		}

		// 组装请求头
		PsbcReqHead head = this.creatSendDataHead(tranCode);
		PsbcReqBaseMsg baseMsg = new PsbcReqBaseMsg();
		baseMsg.setHead(head);
		baseMsg.setData(Obj);

		// 补全日志
		psbcLog.setDecodeReq(JsonUtils.parseObject(baseMsg));
		psbcLog.setTranceCode(tranCode);

		// 核心加密过程 ★ ☆ ★ ☆ ★ ☆ ★ ☆ ★ ☆ ★ ☆ ★ ☆ ★ ☆ ★ ☆ ★
		PsbcReq2AckMsg msg = new PsbcReq2AckMsg();
		try {
		    // 随机生成一个128位的AES秘钥
			String psd = AESUtils.getKeyAES_128();
			// AESKey对data加密，然后RSA服务方公钥对AESKey加密，最后合作方私钥对data加签名
			msg.setEncryptkey(RSAUtils.encrypt(RSAUtils.getPublicKey(dBparam.getServicePublicKey()), psd ,Global.ENCODE_UTF));
			msg.setEncryptdata(AESUtils.encrypt(psd,JsonUtils.parseObject(baseMsg), Global.ENCODE_UTF));
			msg.setSignature(RSAUtils.doSign(JsonUtils.parseObject(baseMsg), dBparam.getWorkPrivateKey(), Global.ENCODE_UTF));
		}catch(Exception e) {
			logger.info("组装请求报文异常:"+e.getMessage());
			return null;
		}
		return JsonUtils.parseObject(msg);
	}
	
	public  PsbcReqHead creatSendDataHead(String tranCode) {
		PsbcReqHead head = new PsbcReqHead();
		head.setFlowno("YC00001");
		head.setSenderDate(Global.getDateFormate_D());
		head.setSenderTime(Global.getDateFormate_M());
		head.setTranCode(tranCode);
		return head;
	}

    /**
     * 解析加密响应
     * @param psbcMsg
     * @param psbcLog
     * @return
     */
    public  PsbcAckBaseMsg  getDecodeResponseData(PsbcReq2AckMsg psbcMsg, DemoLog psbcLog) {
        String decryptdata = "";
        PsbcAckBaseMsg ackMsg = null;
        try {
            // 解密报文，使用合作方私钥
            String strAesPsd = RSAUtils.decrypt(psbcMsg.getEncryptkey(), dBparam.getWorkPrivateKey());
            decryptdata = AESUtils.decrypt(strAesPsd,psbcMsg.getEncryptdata(), Global.ENCODE_UTF);
            logger.info("接收报文，解密后：" + decryptdata);

            // 生成需要验签的报文
            if (StringUtils.isNotEmpty(decryptdata)) {
                return null;
            }
            ackMsg = new PsbcAckBaseMsg();
            ackMsg = JSON.parseObject(decryptdata, PsbcAckBaseMsg.class);

            // 验签，使用服务方公钥
            PublicKey publicKey = RSAUtils.getPublicKey(dBparam.getServicePublicKey());
            boolean flag = RSAUtils.doCheck(ackMsg.getDoSignString(), psbcMsg.getSignature(), publicKey, Global.ENCODE_UTF);
            logger.info("验签结果：" + flag);

            // 补全日志Log
            psbcLog.setDecodeAck(decryptdata);
            psbcLog.setDoCheck(flag ? 1 : 0);
            if(!flag) {
                logger.info("验签未通过!");
                return null;
            }
        }catch(Exception e) {
            logger.error("解析报文异常:" + JsonUtils.parseObject(e));
        }
        return ackMsg;
    }

    /**
     * 创建 HTTP 客户端工厂
     */
	private ClientHttpRequestFactory createFactory() {
		if (this.maxTotalConnect <= 0) {
			SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
			factory.setConnectTimeout(this.connectTimeout);
			factory.setReadTimeout(this.readTimeout);
			return factory;
		}
		HttpClient httpClient = HttpClientBuilder.create().setMaxConnTotal(this.maxTotalConnect)
				.setMaxConnPerRoute(this.maxConnectPerRoute).setRetryHandler(retryHandler).build();
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
		factory.setConnectTimeout(this.connectTimeout);
		factory.setConnectionRequestTimeout(this.connectTimeout);
		factory.setReadTimeout(this.readTimeout);
		return factory;
	}

    HttpRequestRetryHandler retryHandler = new HttpRequestRetryHandler() {
        public boolean retryRequest(
                IOException exception,
                int executionCount,
                HttpContext context) {
            logger.info("重试中的异常：" + exception);
            if (executionCount >= 3) {
                // Do not retry if over max retry count
                return false;
            }
            if (exception instanceof InterruptedIOException) {
                // Timeout
                return false;
            }
            if (exception instanceof UnknownHostException) {
                // Unknown host
                return false;
            }
            if (exception instanceof ConnectTimeoutException) {
                // Connection refused
                logger.info("请求重试！！！");
                return true;
            }
            if (exception instanceof SSLException) {
                // SSL handshake exception
                return false;
            }
            HttpClientContext clientContext = HttpClientContext.adapt(context);
            HttpRequest request = clientContext.getRequest();
            boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
            if (idempotent) {
                // Retry if the request is considered idempotent
                return true;
            }
            return false;
        }
    };
}
