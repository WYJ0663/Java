package com.ptwyj.annotations;


import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by WYJ on 2016-03-11.
 */
public class Wson<T> {

    private static final String GET_METHOD = "get";
    private static final String SET_METHOD = "set";

    public Map<String, Method> obtainMethods(Class clazz, String methodName) {
        Map<String, Method> methodMap = new HashMap<>();// 以set开始的方法的map

        Method[] methods = clazz.getDeclaredMethods();// 获得类的方法集合
        for (Method method : methods) {
            if (method.getName().startsWith(methodName)) {
                methodMap.put(method.getName().toLowerCase(), method);
            }
        }
        return methodMap;
    }


    /**
     * <注解值，字段>
     *
     * @param clazz
     * @return
     */
    public Map<String, Field> obtainFields(Class clazz) {
        Map<String, Field> fieldsMap = new HashMap<>();// 以set开始的方法的map

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(SerializedName.class)) {
                SerializedName serializedName = field.getAnnotation(SerializedName.class);
                String name = serializedName.value();
                fieldsMap.put(name, field);
            }
        }
        return fieldsMap;
    }


    /**
     * @return
     */
    public String toJsonObject(T t) {

        StringBuffer json = new StringBuffer();
        json.append("{");

        Field[] fields = t.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                if (field.isAnnotationPresent(SerializedName.class)) {
                    SerializedName serializedName = field.getAnnotation(SerializedName.class);
                    String name = serializedName.value();
                    // 私有变量必须先设置Accessible为true
                    field.setAccessible(true);

                    Object value = field.get(t);

                    json.append("\"" + name + "\":" + "\"" + value + "\",");//拼接json
                }
            }

            json.deleteCharAt(json.length() - 1);
            json.append("}");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return json.toString();
    }

    public String toJsonArray(List<T> ts) {
        StringBuffer json = new StringBuffer();
        json.append("[");

        for (T t : ts) {
            String jsonObject = toJsonObject(t);
            json.append(jsonObject + "\",");
        }
        json.deleteCharAt(json.length() - 1);
        json.append("]");

        return json.toString();
    }

    public T toObject(T t, String json) {

        Field[] fields = t.getClass().getDeclaredFields();
        try {
            JSONObject jsonObject = new JSONObject(json);
            for (Field field : fields) {
                if (field.isAnnotationPresent(SerializedName.class)) {
                    SerializedName serializedName = field.getAnnotation(SerializedName.class);
                    String name = serializedName.value();
                    // 私有变量必须先设置Accessible为true
                    Iterator iterator = jsonObject.keys();
                    while (iterator.hasNext()) {
                        String key = (String) iterator.next();
                        if (name.equals(key)) {
                            String typeName = field.getType().getName();
                            String value = jsonObject.getString(key);
                            field.setAccessible(true);
                            field.set(t, parseObject(typeName, value));
                            break;
                        }
                    }

                }
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return t;
    }

    String[] types = {Integer.class.getName(),
            Double.class.getName(),
            Float.class.getName(),
            Long.class.getName(),
            Short.class.getName(),
            Byte.class.getName(),
            Boolean.class.getName(),
            Character.class.getName(),
            String.class.getName(),
            "int", "double", "long", "short", "byte", "boolean", "char", "float"};

    private Object parseObject(String typeName, String value) {

        if (typeName.equals(Integer.class.getName()) || typeName.equals("int")) {
            return Integer.parseInt(value);
        } else if (typeName.equals(Double.class.getName()) || typeName.equals("double")) {
            return Double.parseDouble(value);
        } else if (typeName.equals(Long.class.getName()) || typeName.equals("long")) {
            return Long.parseLong(value);
        } else if (typeName.equals(Short.class.getName()) || typeName.equals("short")) {
            return Short.parseShort(value);
        } else if (typeName.equals(Byte.class.getName()) || typeName.equals("byte")) {
            return Byte.parseByte(value);
        } else if (typeName.equals(Boolean.class.getName()) || typeName.equals("boolean")) {
            return Boolean.parseBoolean(value);
        } else if (typeName.equals(Float.class.getName()) || typeName.equals("float")) {
            return Float.parseFloat(value);
        } else if (typeName.equals("char")) {
            return value.charAt(0);
        }

        return value;

    }
}
