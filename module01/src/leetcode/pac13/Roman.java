package leetcode.pac13;

/**
 * @auther Summerday
 */

/**
 * 前值小于后值  总数减去前值
 * 前值大于等于后值  总数加上前值
 * 最后一个值必然要加上
 */
public class Roman {
    public static void main(String[] args) {
        Roman roman = new Roman();
        int m = roman.romanToInt("CMXLIV");
        System.out.println("m = [" + m + "]");
    }
    //根据对应的字符获取相应的数值
    private int getValue(char ch){
        switch(ch){
            case'I':return 1;
            case'V':return 5;
            case'X':return 10;
            case'L':return 50;
            case'C':return 100;
            case'D':return 500;
            case'M':return 1000;
            default:return 0;
        }
    }

    private int romanToInt(String s){
        //sum存取总数值
        int sum = 0;
        //preNum用以存放前值，初始化为第一个字符代表的数值
        int preNum = getValue(s.charAt(0));
        //循环便利，从第二个数开始，与前值对比
        for (int i = 1; i < s.length(); i++) {
        //num存放当前位置上的数值
            int num = getValue(s.charAt(i));
        //前值小于后值，减去前值，否则将其加上
            if(preNum<num){
                sum -=preNum;
            }else{
                sum+=preNum;
            }
        //前值向后移
            preNum = num;
        }
        //循环结束，只剩最后一位值没有处理，加上即可
        sum += preNum;
        return sum;
    }
}
