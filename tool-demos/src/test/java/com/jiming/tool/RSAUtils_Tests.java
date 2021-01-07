package com.jiming.tool;


import com.jiming.tool.utils.AESUtils;
import com.jiming.tool.utils.RSAUtils;
import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 * RSAUtils 工具包测试类
 *
 * @author Mr.tjm
 * @date 2020-5-20 11:25
 */
@SpringBootTest
public class RSAUtils_Tests {

    /**
     * 下面方法验证前需要引入：AESUtils，RSAUtils
     * AESUtils，RSAUtils工具类网上很多，基本是通用的
     * 我也为大家准备好了工具类，方法在我的系列博文中，源码和测试类在github上都已收录
     */
    @Test
    void all_process_T(){
        // 需要加密的字符串
        String sendMesg = "感谢大家关注「IT无知君」，学无止境，气有浩然，天涯未远，有缘再见。";
        System.out.println("1. 需要解密传输的数据（sendMesg）为：" + sendMesg);
        // 用于封装 RSA 随机产生的公钥与私钥
        Map<Integer, String> keyMap = new HashMap<Integer, String>();

        /** AES：随机生成加密秘钥 */
        KeyGenerator keyGen = null;
        try {
            keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        SecretKey key = keyGen.generateKey();
        String AESKeyStr = Base64.encodeBase64String(key.getEncoded());
        System.out.println("2.1 随机生成的AES加密秘钥（AESKeyStr）为：" + AESKeyStr);

        /** RSA：生成公钥和私钥 */
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = null;
        try {
            keyPairGen = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // 初始化密钥对生成器，指定位数，不指定种子
        keyPairGen.initialize(2048, new SecureRandom());

        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   	// 得到 RSA 私钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  		// 得到 RSA 公钥

        // 得到公钥字符串
        String publicKeyStr = new String(Base64.encodeBase64(publicKey.getEncoded()));
        System.out.println("2.2 随机生成的公钥（publicKey）为：" + publicKeyStr);
        // 得到私钥字符串
        String privateKeyStr = new String(Base64.encodeBase64((privateKey.getEncoded())));
        System.out.println("2.3 随机生成的私钥（privateKey）为：" + privateKeyStr);

        /** 加密 and 解密（合作方 → 服务方） */
        // 1.AES秘钥key加密数据
        String EncryData = AESUtils.encrypt(AESKeyStr, sendMesg, "UTF-8");
        System.out.println("3. AES秘钥key加密后的字符串为：" + EncryData);
        // 2.RSA公钥加密AES秘钥key（keyEn）
        String EncryKey = null;
        try {
            EncryKey = RSAUtils.encrypt(AESKeyStr, publicKeyStr);
            System.out.println("4. RSA加密后的AES秘钥key为：" + EncryKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 3.RSA私钥解密AES秘钥key（keyEn）
        String AesKey = null;
        try {
            AesKey = RSAUtils.decrypt(EncryKey, privateKeyStr);
            System.out.println("5. RSA解密后的AES秘钥key为：" + AesKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 4.AES秘钥key解密数据
        String Data = AESUtils.decrypt(AesKey, EncryData, "UTF-8");
        System.out.println("6. AES秘钥key解密后的字符串为：" + Data);
    }
}
