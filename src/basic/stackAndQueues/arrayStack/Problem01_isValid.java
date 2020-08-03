package basic.stackAndQueues.arrayStack;

import java.util.Stack;

/**
 *判断括号顺序是否正确
 */
public class Problem01_isValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
            return stack.isEmpty();
        }

    public static void main(String[] args) {
        System.out.println((new Problem01_isValid()).isValid("()[]{}"));
        System.out.println((new Problem01_isValid()).isValid("({}]"));
    }
    }

