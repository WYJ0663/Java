package com.ptwyj.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015-08-06.
 */
public class Dome4 {
    public static void main(String[] args) {

        //泛型

        //反射的操作都是编译之后的操作

        List<String> list1 = new ArrayList<String>();
        List<Integer> list2 = new ArrayList<Integer>();


        System.out.println(list1.getClass() == list2.getClass());

        //编译后没有泛型
    }
}
