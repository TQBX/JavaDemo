package com.my.innerclasses;

/**
 * @auther Summerday
 */
public class Parcel9 {
    public TestFinal testFinal(final int x){
        final int a = 5;
        return new TestFinal() {
            @Override
            public void m() {

                System.out.println(a+x);
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        p.testFinal(5).m();
    }
}

interface TestFinal{
    void m();
}