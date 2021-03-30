package com.radebit.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author Rade
 * @Date 2021/2/26 14:00:00
 * @Description
 */
public class MainTest {
    @Test
    public void testInfo() {
        System.out.println("success");
    }

    @Test
    public void test01() {
        System.out.println(new Random().nextInt(10000));
        System.out.println(new Random().nextInt(10000));
        System.out.println(new Random().nextInt(10000));
        System.out.println(new Random().nextInt(10000));
        System.out.println(new Random().nextInt(10000));
        System.out.println(new Random().nextInt(10000));
        System.out.println(new Random().nextInt(10000));
        System.out.println(new Random().nextInt(10000));
        System.out.println(new Random().nextInt(10000));
        System.out.println(new Random().nextInt(10000));
        System.out.println(new Random().nextInt(10000));
        System.out.println(new Random().nextInt(10000));
        System.out.println(new Random().nextInt(10000));
        System.out.println(new Random().nextInt(10000));
        System.out.println(new Random().nextInt(10000));
        System.out.println(new Random().nextInt(10000));
        System.out.println(new Random().nextInt(10000));
        System.out.println(new Random().nextInt(10000));
        System.out.println(new Random().nextInt(10000));
        System.out.println(new Random().nextInt(10000));
        System.out.println(new Random().nextInt(10000));
        System.out.println(new Random().nextInt(10000));
        System.out.println(new Random().nextInt(10000));
        System.out.println(new Random().nextInt(10000));
        System.out.println(new Random().nextInt(10000));
        System.out.println(new Random().nextInt(10000));
    }

    @Test
    public void test02() {
        String strOrg = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "\n" +
                "<getUseridByWorkcodeResponse>\n" +
                "  <ns1:out xmlns:ns1=\"http://localhost/services/HrmService\">{\"code\":\"1\",\"userid\":\"1257\"}</ns1:out>\n" +
                "</getUseridByWorkcodeResponse>";
//        StringBuffer stringBuffer = new StringBuffer();
//
//        String[] sMao = strOrg.split(":");
//
//        stringBuffer.append(sMao[0]);
//
//        Pattern pattern1 = Pattern.compile("<.*:.*:.*>");
//        Matcher matcher1 = pattern1.matcher(strOrg);
//
//        StringBuffer sbOrg = new StringBuffer();
//
//        while (matcher1.find()) {
//            sbOrg.append((matcher1.group()));
//        }
//
//        String str = sbOrg.toString();
//
//        String[] split1 = str.split(":");
//
//        stringBuffer.append( ">");
//
//        // 中间数据
//
//        Pattern pattern = Pattern.compile(">(.*?)<");
//        Matcher matcher = pattern.matcher(str);
//
//        while (matcher.find()) {
//            stringBuffer.append(matcher.group(1));
//        }
//
//        stringBuffer.append("</" + split1[0].substring(1) + ">");
//
//        String sEnd = sMao[sMao.length - 1];
//        Pattern pattern2 = Pattern.compile("</.*");
//        Matcher matcher2 = pattern2.matcher(sEnd);
//
//        while (matcher2.find()) {
//            stringBuffer.append((matcher2.group()));
//        }
//
//        System.out.println(stringBuffer);
    }

    @Test
    public void test03(){
        String a = "<?xml version=\"1.0\" encoding=\"utf-8\"?>  <getUseridByWorkcodeResponse>   \n" +
                "<ns1:out xmlns:ns1=\"http://localhost/services/HrmService\">{\"code\":\"1\",\"userid\":\"1257\"}</ns1:out> \n" +
                "<ns1:out xmlns:ns1=\"http://localhost/services/HrmService\"   >{\"code\":\"1\",\"userid\":\"1257\"}</ns1:out>\n" +
                "</getUseridByWorkcodeResponse>";
        Pattern p = Pattern.compile(":.*.*\"(?=>)|(?<=</.{0,500}):.*(?=>)");

        Matcher m = p.matcher(a);
        System.out.println(m.replaceAll(""));
    }
}
