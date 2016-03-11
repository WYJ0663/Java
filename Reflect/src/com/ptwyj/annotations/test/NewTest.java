package com.ptwyj.annotations.test;

import com.ptwyj.annotations.Wson;

/**
 * Created by WYJ on 2016-03-11.
 */
public class NewTest {

    public static void main(String[] args) {

        Wson<Apple> appleWson = new Wson<>();

        Apple apple = new Apple();
        apple.setWeight(12.3);
        apple.setWayOut("中国");
        String json = appleWson.toJsonObject(apple);
        System.out.println(json);

        Apple apple2 = new Apple();
        appleWson.toObject(apple2, "{\"ID\":\"1\",\"NAME\":\"yijun\",\"WEIGHT\":\"12.3\",\"WAY_OUT\":\"123\"}");
        System.out.println(apple2);

    }
}
