package JVM.classloading;

/**
 * @auther Summerday
 */
public interface SubInterface extends SuperInterface{

}
class T{
    public static void main(String[] args) {
        System.out.println(SubInterface.VALUE);
    }
}