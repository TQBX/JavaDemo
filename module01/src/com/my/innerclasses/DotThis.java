package com.my.innerclasses;

/**
 * @auther Summerday
 */
//qualifying access to the outer class object
public class DotThis {
    void f(){
        System.out.println("DotThis.f");
    }
    //using .this to return a reference to outer-class object
    public class Inner{
        public DotThis outer(){
            return DotThis.this;
        }
    }
    public Inner inner(){
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        dti.outer().f();
    }
}

class DotNew{
    public class Inn{}

    public static void main(String[] args) {
        DotNew dn = new DotNew();
        //using .new to create a inner class object
        DotNew.Inn dni = dn.new Inn();
    }
}
