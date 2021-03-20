package com.radebit.test.utils;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import org.junit.Test;

import java.security.PrivateKey;
import java.util.Arrays;

/**
 * @Author Rade
 * @Date 2021/3/5 00:37:37
 * @Description
 */
public class CryptoTest {
    @Test
    public void test01() {
        RSA rsa = SecureUtil.rsa();
        rsa.encrypt("dsf", KeyType.PrivateKey);
    }

    @Test
    public void test02() {
        byte[] data = "我是一段测试字符串".getBytes();
        Sign sign = SecureUtil.sign(SignAlgorithm.MD5withRSA);
        //签名
        byte[] signed = sign.sign(data);
        //验证签名
        boolean verify = sign.verify(data, signed);

        System.out.println(sign.getPrivateKey());
        System.out.println(sign.getPublicKey());
        System.out.println(verify);
        System.out.println(sign.getPrivateKeyBase64());
        System.out.println(sign.getPublicKeyBase64());
    }

    @Test
    public void test03() {
    }
}
