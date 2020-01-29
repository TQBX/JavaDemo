package com.my.innerclasses;

/**
 * @auther Summerday
 */
public class Parcel1 {
    //Create an inner class Contents
    class Contents{
        private int i = 11;
        public int value(){
            return i;
        }
    }
    //Create another inner class Destination
    class Destination{
        private String label;
        Destination(String whereTo){
            this.label = whereTo;
        }
        String readLabel(){
            return label;
        }

    }
    // using inner classes looks just like using
    // any other class,within Parcel1
    public void ship(String dest){
        Contents c = new Contents();
        System.out.println(c.value());
        Destination d = new Destination(dest);
        System.out.println(d.readLabel());
    }
    public static void main(String[] args) {
        Parcel1 p = new Parcel1();
        p.ship("China");
    }
}

