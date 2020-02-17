package com.my.reflect.practice;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther Summerday
 */

@SuppressWarnings("unchecked")
public class TST {
    public static void main(String[] args) throws Exception {
        List<Integer> ins = new ArrayList<>();
        ins.add(3);
        ins.add(3);
        ins.add(3);
        //泛型的擦除，发生再编译器
        //反射是动态加载的，意味着在编译器根本不确定要加载哪一类

        //导致泛型在反射期间无法限定
        Class<List> clz = (Class<List>) ins.getClass();
        Method m = clz.getDeclaredMethod("add",Object.class);
        m.invoke(ins,"abc");

        System.out.println(ins);
    }
}
