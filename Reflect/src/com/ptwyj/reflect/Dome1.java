package com.ptwyj.reflect;

/**
 * Created by Administrator on 2015-08-06.
 */
public class Dome1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class c1 = Foo.class;

        Foo foo = new Foo();

        Class c2 = foo.getClass();

        System.out.println(c1 == c2);

        //动态加载类
        Class c3 = Class.forName("com.ptwyj.reflect.Foo");

        System.out.println(c3 == c2);

        Foo foo1 = (Foo) c3.newInstance();//需要无参数的构造方法
    }


}
//类也是对象，是Class类的实例对象
//这个对象我们称为该类的类类型

class Foo {

}