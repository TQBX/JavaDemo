package com.my.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @auther Summerday
 */
public class HashMapDemo {
    public static void main(String[] args) {
        //获取一个字符串
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        //定义一个Map用于记录字符已经对应的次数
        Map<Character,Integer> map = new HashMap<>();

        //遍历字符串
        char[]cs = str.toCharArray();
        for(char c:cs){
            //判断字符是否出现过
            if(map.containsKey(c))
                //如果字符出现过，那得在之前的次数上+1
                map.put(c,map.get(c)+1);
            else
                map.put(c,1);
        }


        //Entry是Map接口的内部接口，Map.Entry<Character,Integer> entry
        for(Map.Entry<Character,Integer> entry:map.entrySet())
            System.out.println(entry.getKey()+":"+entry.getValue());
    }
}
