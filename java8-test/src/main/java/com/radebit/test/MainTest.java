package com.radebit.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
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
    public void test03() {
        String a = "<?xml version=\"1.0\" encoding=\"utf-8\"?>  <getUseridByWorkcodeResponse>   \n" +
                "<ns1:out xmlns:ns1=\"http://localhost/services/HrmService\">{\"code\":\"1\",\"userid\":\"1257\"}</ns1:out> \n" +
                "<ns1:out xmlns:ns1=\"http://localhost/services/HrmService\"   >{\"code\":\"1\",\"userid\":\"1257\"}</ns1:out>\n" +
                "</getUseridByWorkcodeResponse>";
        Pattern p = Pattern.compile(":.*.*\"(?=>)|(?<=</.{0,500}):.*(?=>)");

        Matcher m = p.matcher(a);
        System.out.println(m.replaceAll(""));
    }

    /**
     * 合并两个有序数组
     */
    @Test
    public void test04() {
        int A[] = {1, 2, 3, 4, 6, 6};
        int B[] = {2, 2, 5, 9, 12, 13, 15};
        int m = 6;
        int n = 7;
        int[] newArr = new int[m + n];
        int aIndex = m - 1;
        int bIndex = n - 1;
        for (int i = newArr.length - 1; i >= 0; i--) {
            if (aIndex == -1) {
                // A先循环完成，后面是数据填充B剩余数据即可
                newArr[i] = B[bIndex];
                bIndex--;
            } else if (bIndex == -1) {
                // B先循环完成，后面是数据填充A剩余数据即可
                newArr[i] = A[aIndex];
                aIndex--;
            } else {
                if (A[aIndex] < B[bIndex]) {
                    newArr[i] = B[bIndex];
                    bIndex--;
                } else {
                    newArr[i] = A[aIndex];
                    aIndex--;
                }
            }

        }
        System.out.println(Arrays.toString(newArr));
    }

    @Test
    public void test05(){
//        HashMap
//        ArrayList
        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.incrementAndGet();
        System.out.println(atomicInteger);
    }
}
