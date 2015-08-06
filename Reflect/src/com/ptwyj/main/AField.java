package com.ptwyj.main;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//指定了注解保留的周期  //编译器将把注释记录在类文件中，在运行时 VM 将保留注释，因此可以反射性地读取  。
@Target({ ElementType.FIELD })
public @interface AField {

	String value();
	
}
