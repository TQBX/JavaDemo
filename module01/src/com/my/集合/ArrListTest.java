package com.my.集合;

/**
 * @auther Summerday
 */
//测试类
public class ArrListTest {
    public static void main(String[] args) {
        ArrList data = new ArrList();
        System.out.println(data);

        ArrList a = new ArrList(1);
        a.add("天");
        a.add("乔");
        a.add("巴");
        String[] arr = a.toArray();
        for(String s: arr){
            System.out.println(s);
        }
        a.remove(0);
        System.out.println(a);
        System.out.println(a.subListCopyArray(0, 1));
        System.out.println(a.subListTraversal(0, 1));
        System.out.println(a.size());
        System.out.println(a.isEmpty());
        a.trimToSize();
        a.clear();
        System.out.println(a);
    }
}
