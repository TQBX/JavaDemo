package com.my.innerclasses;

/**
 * @auther Summerday
 */
//Create a constructor for an anonymous inner class
public class Parcel8 {
    public Wrapping wrapping(int value){
        return new Wrapping(value){
          public int getValue(){
              return super.getValue()*5;
          }
        };
    }

    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        int value = p.wrapping(10).getValue();
        System.out.println(value);//50
    }
}

class Wrapping{
    private int value;
    Wrapping(int value){
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
