package com.ptwyj.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2015-08-06.
 */
public class Dome3 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class c1 = int.class;
        Class c2 = String.class;

        System.out.println(c2.getName());
        System.out.println(c2.getSimpleName());

        Method[] methods = c2.getMethods();//所有public的函数，包括从父类继承的
        Method[] members2 = c2.getDeclaredMethods();//自己声明的所以函数，不问权限


        for (int i = 0; i < methods.length; i++) {
            Class returnType = methods[i].getReturnType();

            System.out.println(returnType.getName());
            System.out.println(methods[i].getName());
            Class[] paramType = methods[i].getParameterTypes();

            for (int j = 0; j < paramType.length; j++) {

                System.out.println(paramType[j].getName());
            }

            methods[i].invoke(c2);//调用函数
        }
        c2.getMethod("name");

        Field[] files = c2.getFields();//public 字段
        c2.getDeclaredFields();//自己声明


        Constructor[] constructor = c2.getConstructors();//构造函数



    }
}
