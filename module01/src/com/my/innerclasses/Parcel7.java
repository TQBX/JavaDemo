package com.my.innerclasses;

/**
 * @auther Summerday
 */
//Returning an instance of an anonymous inner class.

public class Parcel7 {
    public Contents contents(final int v){
        return new Contents() {
            //为匿名内部类的字段初始化
            private int value = v;
            @Override
            public int value() {
                return value;
            }
        };
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        int value = p.contents(500).value();
        System.out.println(value);
    }
}
interface Contents{
    int value();
}
//上述其实就是下面的简化
class Parcel7b{
    class Mycontents implements Contents{
        private int value = 50;
        @Override
        public int value() {
            return value;
        }
    }
    public Contents contents(){
        return new Mycontents();
    }

    public static void main(String[] args) {
        Contents c = new Parcel7b().contents();
        int value = c.value();
        System.out.println(value);
    }
}

