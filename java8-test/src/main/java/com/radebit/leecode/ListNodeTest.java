package com.radebit.leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author Rade
 * @Date 2021/3/18 15:28:28
 * @Description
 */
public class ListNodeTest {
    @Test
    public void test01() {
//        int[] arr = {4,5,1,6,2,7,3,8};
//        Arrays.stream(arr).sorted().limit(4).forEach(System.out::println);
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(5);
        list.add(2);
        list.add(3);
//        list.forEach(System.out::println);

        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.remove(2));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
