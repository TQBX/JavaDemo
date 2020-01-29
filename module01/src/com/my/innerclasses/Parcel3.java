package com.my.innerclasses;

/**
 * @auther Summerday
 */
public class Parcel3 {
    class Contents{
        private int i = 20;
        public int value(){
            return i;
        }
    }

    public static void main(String[] args) {
        Parcel3 p = new Parcel3();
        Parcel3.Contents pc = p.new Contents();
        System.out.println(pc.value());
    }
}
