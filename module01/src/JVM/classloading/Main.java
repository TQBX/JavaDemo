package JVM.classloading;

/**
 * @auther Summerday
 */

public class Main{
    public static void main(String[] args) {
        System.out.println(SubClass.value);

        //SuperClass.static initializer
        //123


        //对于静态字段，只有直接定义这个字段的类才会被初始化。通过子类来引用父类中定义的静态字段，只会触发父类的初始化而不会触发
        //子类的初始化。

//        SubClass[] sca = new SubClass[10];

//        System.out.println(ConstClass.VALUE);
    }




}