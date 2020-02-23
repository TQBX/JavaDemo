package JVM.classloading;

/**
 * @auther Summerday
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass.static initializer");
    }

    public static int value = 123;

//    public static int value = 143;
}

