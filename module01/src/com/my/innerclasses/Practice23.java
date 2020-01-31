package com.my.innerclasses;

/**
 * @auther Summerday
 */
public class Practice23 {
    public static void main(String[] args) {
        U[] us = new U[]{new A().u(),new A().u(),new A().u()};
        B b = new B(5);
        U[] uss = b.test(us);
        for(U u:uss){
            u.f1();
            u.f2();
            u.f3();
        }


    }
}
class A{
    public U u(){
        return new U() {
            @Override
            public void f1() {
                System.out.println("A.f1");
            }

            @Override
            public void f2() {
                System.out.println("A.f2");
            }

            @Override
            public void f3() {
                System.out.println("A.f3");
            }
        };
    }
}
class B{
    U[] us;
    int size = 0;
    B(int cap){
        us = new U[cap];
    }
    public void add(U u){
        if(size<us.length)
            us[size++] = u;
    }

    public U[] test(U[] us){
        for (U u : us) {
            this.add(u);
        }
        return us;

    }

}


interface U{
    void f1();
    void f2();
    void f3();
}
