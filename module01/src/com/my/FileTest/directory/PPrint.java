package com.my.FileTest.directory;

import java.util.Arrays;
import java.util.Collection;

/**
 * @auther Summerday
 */

/**
 * 自定义打印类
 */
public class PPrint {
    public static String pformat(Collection<?> c){
        if(c.size() == 0) return "[]";
        StringBuilder result = new StringBuilder("[");
        for(Object elem :c){
            if(c.size()!=1)
                result.append("\n  ");
            result.append(elem);
        }

        if(c.size()!=1)
            result.append("\n  ");
        result.append("]");
        return result.toString();
    }
    //接收集合对象
    public static void pprint(Collection<?> c){
        System.out.println(pformat(c));
    }
    //接收Object类型的数组对象
    public static void pprint(Object[]c){
        System.out.println(pformat(Arrays.asList(c)));
    }
}
