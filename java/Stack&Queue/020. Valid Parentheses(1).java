import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else {
                switch (c) {
                    case ')':
                        if (!stack.empty() && stack.peek() == '(') stack.pop();
                        else return false;
                        break;
                    case ']':
                        if (!stack.empty() && stack.peek() == '[') stack.pop();
                        else return false;
                        break;
                    case '}':
                        if (!stack.empty() && stack.peek() == '{') stack.pop();
                        else return false;
                        break;
                }
            }
        }
        if(stack.empty()) return true;
        return false;

    }
}
