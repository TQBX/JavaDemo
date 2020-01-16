package leetcode.stringTest.pac28;

/**
 * @auther Summerday
 */
public class ImplementStr {


    public static void main(String[] args) {
        ImplementStr im = new ImplementStr();
        System.out.println(im.strStr("hello", "ll"));
    }

    public int strStr(String haystack,String needle){
        if(haystack.length()<needle.length()) return -1;
        return haystack.indexOf(needle)!=0?haystack.indexOf(needle):-1;
    }
}
