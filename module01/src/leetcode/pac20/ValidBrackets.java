package leetcode.pac20;

import java.util.HashMap;
import java.util.Stack;

/**
 * @auther Summerday
 */
public class ValidBrackets {
    public static void main(String[] args) {
        ValidBrackets validBrackets = new ValidBrackets();
        String testString = "(((";
        System.out.println(validBrackets.isValid(testString));
    }

    private HashMap<Character, Character> mappings;

    public ValidBrackets() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put(']', '[');
        this.mappings.put('}', '{');
    }

    public boolean isValid(String s) {
        //初始化栈
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //如果遇到右半边的括号的话
            if (this.mappings.containsKey(c)) {
                //取栈顶元素，如果栈为空，给栈顶元素暂时赋值，不然后面会出现
                //EmptyStackException
                char topElement = stack.empty() ? '#' : stack.pop();
                //栈顶元素和匹配值不相符，直接返回错误
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                //如果没有遇到右半边的括号，将左半边入栈
                stack.push(c);
            }
        }
        //两边完全抵消，即为有效符号
        return stack.isEmpty();
    }

}