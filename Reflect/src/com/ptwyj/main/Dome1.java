package com.ptwyj.main;

import com.ptwyj.main.Test;

/**
 * Created by Administrator on 2015-08-06.
 */
public class Dome1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class c1 = Test.class;

        Test test = new Test();

        Class c2 = test.getClass();

        System.out.println(c1 == c2);

        //动态加载类
        Class c3 = Class.forName("com.ptwyj.reflect.Test");

        System.out.println(c3 == c2);

        Test Test1 = (Test) c3.newInstance();//需要无参数的构造方法
    }


}
//类也是对象，是Class类的实例对象
//这个对象我们称为该类的类类型

