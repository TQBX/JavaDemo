package leetcode.pac09;

/**
 * @author Summerday
 * @date 2019/12/3 18:49
 */
public class Palindrome {
    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        boolean boo = p.isPalindrome(121);
        System.out.println(boo);


        Palindrome p01 = new Palindrome();
        boolean boo01 = p01.isPalindrome01(1221);
        System.out.println(boo01);


        Palindrome p02 = new Palindrome();
        boolean boo02 = p02.isPalindrome02(10301);
        System.out.println(boo02);
    }
    //数学解法
    public boolean isPalindrome(int x){
        System.out.println("****数学解法****");
        if(x<0) return false;
        int num = x;
        //算出最高位数的整10数
        int div = 1;
        while(x/10>=1){
            div*=10;
            x/=10;
        }
        //System.out.println(num);
        while(num>0){
            //比较左右两边的数
            int left = num/div;
            int right = num%10;
            if(left!=right) return false;
            //抽取中间的数
            num = (num%div)/10;//22
            div/=100;//每次少两位，除以100//10
        }
        return true;
    }

    //字符串解法
    public boolean isPalindrome01(int x){
        System.out.println("****字符串解法****");
        String reversedStr = (new StringBuilder(x+"")).reverse().toString();
        return (x+"").equals(reversedStr);
    }

    //翻转解法
    public boolean isPalindrome02(int x){
        System.out.println("****翻转解法****");
        //判断不符合条件 x<0 or x的最低位为0
        if(x<0||(x%10==0&&x!=0)) return false;
        //取后一半的数，进行翻转操作，翻转操作.
        //超过一半的话结束，一半的条件如何获取？
        //假设1221，取出后两位21 翻转成12 此时刚好与前面的12相等
        //这时如果再取出一位2，就比原来的数字大了，这时候就超过了一半
        //所以原来的数>取出后翻转的数，在这个范围内，都可以进行翻转
        //接下来是翻转操作。
        int rev = 0;

        while(x>rev){
            int pop = x%10;
            x/=10;
            rev = rev*10+pop;
        }
        // 偶数的情况 翻转之后刚好相等 即x==rev
        // 奇数的情况 翻转之后的数比原先的数多了一位中间的值 如121
        //翻转之后的数位12 之前还剩下 1  这时只需要将12/10取整 再比较。
        return x==rev||x==rev/10;

    }
}

