package com.my.StackOverflowQ.regexSplit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @auther Summerday
 */
public class SplitExample {

    private static Pattern twopart = Pattern.compile("(\\d+)-(\\d+)");
    public static void checkString(String s){
        Matcher m = twopart.matcher(s);
        if(m.matches()){
            System.out.println(s+" matches;first part is: "+m.group(1)+
                    ", second part is:0 "+m.group(2));
        }else{
            System.out.println(s+" does not match");
        }
    }

    public static void main(String[] args) {
        checkString("111-5555");
        checkString("55--5555");
        checkString("-2615");
        checkString("1515-");
        checkString("156-154-45");
    }
}
