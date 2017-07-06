import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();


        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') stack.push(i);

            else {
                if(!stack.empty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                }

                else stack.push(i);
            }
        }

        int len = 0, r = s.length();

        if(stack.empty()) len = r;

        else {
            while(!stack.empty()) {
                len = Math.max(len, r - stack.peek() - 1);
                r = stack.pop();
            }

            len = Math.max(r, len);
        }

        return len;


    }
}
