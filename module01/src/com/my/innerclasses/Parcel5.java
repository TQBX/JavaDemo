package com.my.innerclasses;

/**
 * @auther Summerday
 */
//Nesting a class within a method
public class Parcel5 {
    public Dest showDest(String s){
        //Destina 是方法的一部分，而不是Parcel5的一部分
        class Destina implements Dest{
            private String label;
            private Destina(String s){
                label = s;
            }
            @Override
            public String readLabel() {
                return label;
            }
        }
        //向上转型： Dest = new Destina(s)
        return new Destina(s);


    }
    //不会有命名冲突
    class Destina{

    }
}


interface Dest{
    String readLabel();
}

class DestTest{
    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Dest d = p.showDest("China");
        String label = d.readLabel();
        System.out.println(label);
    }
}