package leetcode.pac14;

/**
 * @auther Summerday
 */
public class LongestCommon {
    public static void main(String[] args) {
        String[] strs = new String[]{"a", "b", "c"};
//        System.out.println(longestCommonPrefix00(strs));
//        System.out.println(longestCommonPrefix01(strs));
//        System.out.println(longestCommonPrefix02(strs));
        System.out.println(longestCommonPrefix03(strs));
    }
    //官方题解1 水平扫描
    //时间复杂度：o(s) s 是所有字符串中字符数量的总和 即n个字符串都相同时，s1会与之后所有都比较
    //空间复杂度 o(1)
    public static String longestCommonPrefix00(String[] strs){
        if(strs==null||strs.length==0) return "";//传进空数组

        //将第一个字符串作为暂时作为公共前缀
        String prefix = strs[0];

        for (int i = 1; i < strs.length ; i++) {
            while(strs[i].indexOf(prefix)!=0){//不等于0说明第一个字符串并不是该字符串的前缀，则向前推移
                //prefix.substring(0,prefix.length()-1)  除去该字符串的最后一个字符
                prefix = prefix.substring(0,prefix.length()-1);
                //取到第一个字符，还是没有公共前缀，返回“”
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    //官方题解2 水平扫描
    public static String longestCommonPrefix01(String[] strs){
        if(strs==null||strs.length==0) return "";
        //该for循环表示从前往后遍历比较某一个字符串每个位上的字符
        for(int i = 0;i<strs[0].length();i++){
            char c = strs[0].charAt(i);
            //该for循环表示从第二个字符串开始，从前往后遍历传入数组中的每个字符串
            for(int j = 1;j<strs.length;j++){
                // 两个判断条件：i
                // 1.i==strs[j].length()
                // i表示第一个字符串的位数，如果i和后面字符串的长度相等，就不对（位数是从0开始计数的，长度从1开始的）
                // 2.strs[j].charAt(i)!=c
                // 后面的字符串在相同位数时，字符不一致，即不对。
                // 两者情况任一满足一个，就返回第一个字符串0~i-1位数的字符串

                if(i==strs[j].length()||strs[j].charAt(i)!=c){
                    //public String substring(int beginIndex,int endIndex)
                    //返回一个字符串，该字符串是此字符串的子字符串。
                    // 子串开始于指定beginIndex并延伸到字符索引endIndex - 1 。
                    return strs[0].substring(0,i);

                }
            }
        }
        return strs[0];
    }
    //官方题解3 分治
    public static String longestCommonPrefix02(String[] strs){
        if(strs == null||strs.length==0) return "";
        return longestCommonPrefix(strs,0,strs.length-1);
    }
    private static String longestCommonPrefix(String[] strs,int left,int right){
        //跳出递归的情况
        if(left==right){
            return strs[left];
        }
        else{
            //分治
            int mid = (left+right)/2;
            String lcpLeft = longestCommonPrefix(strs,left,mid);
            String lcpRight = longestCommonPrefix(strs,mid+1,right);
            return CommonPrefix(lcpLeft,lcpRight);
        }
    }
    //普通比较两个字符串的最长前缀的方法，按字符比较，最多是到其中较短的字符串的长度位数位置
    private static String CommonPrefix(String left,String right){
        //min变量存储较短字符串的长度
        int min = Math.min(left.length(),right.length());
        for (int i = 0; i < min; i++) {
            //两边字符串对应字符比较，一旦不一样，就截取到之前一位
            if(left.charAt(i)!=right.charAt(i)) return left.substring(0,i);
        }
        //跳出for循环，说明较短的字符串就是公共前缀
        return left.substring(0,min);
    }
    //官方题解4 二分查找
    public static String longestCommonPrefix03(String[] strs){
        if(strs==null||strs.length==0) return "";
        int minLen = Integer.MAX_VALUE;
        //最长公共前缀的最大可能长度就是最短的字符串长度
        //找出字符串数组中最短字符串的长度  minLen
        for(String str:strs)
            minLen = Math.min(minLen,str.length());
        int low = 1;
        int high = minLen;
        while(low<=high){
            //将查找空间一分为二
            int mid =(low+high)/2;
            //如果第一个字符串前面一半字符是所有串的公共前缀，那么就可以丢弃前一半查找空间
            if(isCommonPrefix(strs,mid))
                low = mid +1;
            //如果不是的话，丢弃后一半
            else
                high = mid -1;
        }
        //找到最长前缀的最后位置，并返回
        return strs[0].substring(0,(low+high)/2);
    }
    //判断传入数组的第一个字符串的前len位是不是后面的前缀，是返回true， 不是返回false
    private static boolean isCommonPrefix(String[] strs,int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++) {
            if(!strs[i].startsWith(str1))
                return false;

        }
        return true;
    }

}
