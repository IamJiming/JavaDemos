package com.jiming.tool.domain;

/**
 * 功能：tcp请求返回的加密数据
 * 说明：
 * @author Mr.tjm
 * @date 2020-5-20 11:25
 */
public class Req2AckMsg {
	// 经过服务方公钥加密后的AES密钥
	private String encryptkey;
	// 经过AES加密的密文
	private String encryptdata;
	// signature签名
	private String signature;

	public String getEncryptkey() {
		return encryptkey;
	}
	public void setEncryptkey(String encryptkey) {
		this.encryptkey = encryptkey;
	}
	public String getEncryptdata() {
		return encryptdata;
	}
	public void setEncryptdata(String encryptdata) {
		this.encryptdata = encryptdata;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Req2AckMsg{");
		sb.append("encryptkey='").append(encryptkey).append('\'');
		sb.append(", encryptdata='").append(encryptdata).append('\'');
		sb.append(", signature='").append(signature).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
