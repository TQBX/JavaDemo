package com.my.finalUse.demo;

import java.util.Arrays;
import java.util.Random;

/**
 * @auther Summerday
 */

class Value{
    int i;//package access
    public Value(int i){
        this.i =i;
    }

}
/*final域在使用前必须被初始化：定义时，构造器中*/
public class FinalData {
    /*检测传入参数*/
    int param0 = 5;
    final int param1 = 10;
    static final int PARAM_2 = 15;
    static int param3 = 20;
    private static Random rand = new Random(47);
    private final String id;//空白final
    public FinalData(){
        id = "空白final默认id";
    }
    public FinalData(String id){
        this.id = id;
    }
    //带有编译时数值的final基本类型
    private final int valueOne = 9;
    private static final int VALUE_TWO = 99;
    //典型常量的定义方式
    public static final int VALUE_THREE = 39;
    //在编译是不能知道其值
    private final int i4 = rand.nextInt(20);
    static final int INT_5 = rand.nextInt(20);
    private Value v1 = new Value(1);
    private final Value v2 = new Value(22);
    private static final Value V_3 = new Value(333);

    private final int[] a = {1,2,3,4,5,6};
    @Override
    public String toString(){
        return id+": "+"i4 = "+i4+",INT_5 = "+INT_5;
    }
    public int finalParamTest(final int i){
        //!false:i++;
        //不让改，只让读
        return i+1;
    }
    public void finalReferenceTest(final FinalData fd){
        //!false:fd = new FinalData();
        //不能再指向新的对象，存储地址不准变
        fd.param0++;

    }

    public static void main(String[] args) {
        FinalData fd1 = new FinalData("fd1");
        /*基本类型变量*/
        //!false:fd1.valueOne++;
        //!false:fd1.VALUE_TWO++;
        //!false:fd1.VALUE_THREE++;
        /*引用变量*/
        fd1.v1 = new Value(10);//可以的，因为引用变量并不是常量，存储地址可以改变
        //v2是引用变量，里面存的是对象的地址，final修饰之后表示地址不能改变
        //但是，实际对象的值是可以改变的
        fd1.v2.i++;//实际对象并不是常量
        //!false:fd1.v2 = new Value(3);
        System.out.println("fd1.v2.i = [" + fd1.v2.i + "]");


        //!false:fd1.V_3 = new Value(10);
        fd1.V_3.i++;
        System.out.println("fd1.V_3.i = [" + fd1.V_3.i + "]");
        /*引用变量之数组*/
        System.out.println("before:fd1.a[] = " + Arrays.toString(fd1.a));

        /*数组引用变量a是final修饰，
        但是不代表它指向的数据值是final，
        而是a存储的地址值不能改变
         */
        //!false:fd1.a = new int[]{2,3,4,5,6,7};
        for (int i = 0; i < fd1.a.length; i++) {
            fd1.a[i]++;
        }
        System.out.println("after :fd1.a[] = " + Arrays.toString(fd1.a));
        /*final 与final static*/
        //下面示例分别创建了三个不同的对象，对其final 和final static 进行测试
        /*
        * 可以发现，三个对象的i4值是随机生成且不能改变的，且不相同
        * 而INT_5的值不随对象改变而改变，因为被static修饰，在类加载时已经被初始化*/
        System.out.println(fd1);//fd1: i4 = 15,INT_518

        FinalData fd2 = new FinalData("fd2");
        //!false:fd2.i4++;
        //!false:fd2.INT_5++;
        System.out.println(fd2);//fd2: i4 = 13,INT_518
        FinalData fd3 = new FinalData("fd3");
        System.out.println(fd3);//fd3: i4 = 1,INT_5 = 18

        //!false:System.out.println(fd1.finalParamTest(param0));
        //!false:System.out.println(fd1.finalParamTest(param1));
        //non-static field'param1' cannot be referenced from a static context
        System.out.println(fd1.finalParamTest(PARAM_2));
        System.out.println(fd1.finalParamTest(param3));
        /*为什么形参列表里的参数用final修饰，但是用final修饰的param1无法传进去，
        一定要static修饰？*/

        System.out.println("fd1.param0 = "+fd1.param0);
        fd1.finalReferenceTest(fd1);
        System.out.println("fd1.param0 = "+fd1.param0);
    }

}
