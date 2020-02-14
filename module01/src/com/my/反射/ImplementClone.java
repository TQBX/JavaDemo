package com.my.反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @auther Summerday
 */
public class ImplementClone {
    public Object clone(Object o) throws Exception{
        //获取对象的实际类型
        Class<Object> clz = (Class<Object>) o.getClass();


        //获取所有构造方法
        Constructor<Object>[] cs = (Constructor<Object>[]) clz.getDeclaredConstructors();
        Constructor<Object> c = cs[0];

        //执行这个构造方法，获取对象
        //可能没有参数，也可能有，有的话，参数类型是啥

        //获取参数类型
        Class[] ps = c.getParameterTypes();
        //存储参数的数组
        Object[] os = new Object[ps.length];
//        if(ps.length != 0),说明有参数
        //基本or引用？

        for(int i = 0;i<ps.length;i++){
            //判断是否为基本类型
            if(ps[i].isPrimitive()){
                if(ps[i] == boolean.class)
                    os[i] = false;
                else if(ps[i] == char.class)
                    os[i] = '\u0000';
                else
                    os[i] = 0;
            }else{
                os[i] = null;
            }
        }
        //执行构造方法创建对象
        Object obj = c.newInstance(os);

        //获取属性数组
        Field[] fs = clz.getDeclaredFields();

        for (Field f : fs){
            //暴力破解
            f.setAccessible(true);

            //取出原属性值
            Object value = f.get(o);

            //将取出的属性值赋值给新对象的属性
            f.set(obj,value);
        }

        return obj;
    }
}
