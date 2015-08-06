package com.ptwyj.reflect;

/**
 * Created by Administrator on 2015-08-06.
 */
public class Dome2 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class clazz = Class.forName(args[0]);

        OfficeAble officeAble = (OfficeAble) clazz.newInstance();

        officeAble.start();

    }
}
