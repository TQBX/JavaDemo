package com.my.innerclasses;

/**
 * @auther Summerday
 */
public class Parcel2 {
    class Contents{
        private int i = 20;
        public int value(){
            return i;
        }
    }
    //returning a reference to an inner class
    public Contents contents(){
        return new Contents();
    }
    public void display(){
        Contents c = new Contents();
        System.out.println(c.value());
    }

}
class Test{
    public static int show(){
        Parcel2 p = new Parcel2();
        //OuterClassName.InnerClassName
        Parcel2.Contents c = p.contents();
        return c.value();
    }

    public static void main(String[] args) {
        System.out.println(show());
    }
}