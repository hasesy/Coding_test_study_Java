package algorithm.week02;

import java.util.Stack;

public class RotateParentheses {
    public int solution(String s) {
        int count = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            String str = s.substring(i, length) + s.substring(0, i);

            boolean flag = isValid(str);
            if (flag) {
                count++;
            }
        }
        return count;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char check = stack.peek();
                    if (c == ')' && check == '(') {
                        stack.pop();
                    } else if (c == '}' && check == '{') {
                        stack.pop();
                    } else if (c == ']' && check == '[') {
                        stack.pop();
                    } else return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
