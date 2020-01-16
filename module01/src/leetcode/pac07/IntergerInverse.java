package leetcode.pac07;

/**
 * @author Summerday
 * @date 2019/12/2 22:07
 */

/**
 * 判断溢出情况：
 *
 * `temp = rev*10+pop` 的溢出情况
 *
 * 1. `rev*10>Interger.MAX_VALUE`，时一定溢出。
 * 2.` rev*10==Interger.MAX_VALUE`时，也就是说temp值的最后一位是pop，我们需要知道Integer的便界值是多少，
 * 2^31-1的最后一位为7，也就是说只要pop>7时，temp值就比Integer的最大值要大了。
 * 3. 所以综上：判断正溢出的语句为：` if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
 * return 0;`同理，负边界为2^-31最后一位是-8，所以判断负溢出的条件为：`if (rev < Integer.MIN_VALUE/10 ||
 * (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;`
 *
 *
 * 另外，这里如果不知道最后一位，可以通过`Integer.MAX_VALUE%10`或`Integer.MIN_VALUE%10`计算。
 */
/*
 *给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class IntergerInverse {
    public static void main(String[] args) {
        IntergerInverse test = new IntergerInverse();
        int[] nums = new int[]{123,234,456,789};
        for(int num:nums) System.out.println(test.inverse(num));
        int m = test.inverse(1234567111);
        System.out.println(m);
    }

    public int inverse(int i) {

        int rev = 0;
        while (i != 0) {
            int pop = i % 10;
            i /= 10;
            //判定溢出条件
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;

    }
}
