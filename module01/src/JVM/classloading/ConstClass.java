package JVM.classloading;

/**
 * @auther Summerday
 */
public class ConstClass {
    static{
        System.out.println("ConstClass.static initializer");
    }
    public static final int VALUE = 123;
}
