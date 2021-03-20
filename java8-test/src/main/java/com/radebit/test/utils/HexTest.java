package com.radebit.test.utils;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;
import org.junit.Test;

/**
 * @Author Rade
 * @Date 2021/3/5 00:05:05
 * @Description
 */
public class HexTest {
    @Test
    public void test1() {
        String str = "我是一个字符串";

        String hex = HexUtil.encodeHexStr(str, CharsetUtil.CHARSET_UTF_8);

        String decodedStr = HexUtil.decodeHexStr(hex);

        System.out.println(hex);
        System.out.println(decodedStr);


        System.out.println(HexUtil.decodeHexStr("0x9184e72a"));
    }
}
