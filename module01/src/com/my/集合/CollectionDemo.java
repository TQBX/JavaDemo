package com.my.集合;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @auther Summerday
 */
public class CollectionDemo {
    public static void main(String[] args) {
//        String[] arr = {"2","3"};
//        System.out.println(arr.getClass());
//        System.out.println(arr[0].getClass());

//        //表示存储的元素是字符串
        Collection<String> c = new ArrayList<>();
//
//        //添加数据
//        c.add("天");
//        c.add("乔");
//        c.add("巴");
//        c.add("夏");
//        Iterator<String> iterator = c.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        ArrayList<String> arrayList = new ArrayList<>(0);
        System.out.println(arrayList);
//        arrayList.add("5");
//        ArrayList<String> arrayList1 = new ArrayList<>();
//        arrayList1.add("5");
//        System.out.println(arrayList1.get(2));

//        arrayList.remove(-1);
//        ArrayList<String> arrayList2 = new ArrayList<>(arrayList1);
//        System.out.println(arrayList1.size());

//        System.out.println(c);
//        //将集合转换为数组
////        Object[] arr = c.toArray();
////        for(Object o: arr) System.out.println(o);
//        //!false:String[] arr = (String[]) c.toArray();
//
//        //在进行转换的时候要告诉当前集合要转化为string[]
//        String[] arr = c.toArray(new String[0]);
//
//        //移除元素(首先会判断元素是否存在)
//        c.remove("天");
//        c.remove("春");
//        //判断是否包含指定的元素
//        System.out.println(c.contains("天"));
//        System.out.println(c);
//
//        //清空集合
//
//        c.clear();
//        System.out.println(c);
//
//        //判断集合中是否有元素
//        System.out.println(c.isEmpty());
//
//        //返回集合中元素的个数
//        System.out.println(c.size());


//        //遍历集合
//        //1、增强for循环
//        for(String str:c) System.out.print(str);
//        //2、forEach方法1.8
//        c.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.print(s);
//            }
//        });
//        //TODO LAMBDA
//        c.forEach(s -> System.out.print(s));

//        c.forEach(System.out::print);

    }
}
