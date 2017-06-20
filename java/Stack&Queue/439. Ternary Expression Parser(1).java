import java.util.Stack;

public class Solution {
    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();
        for(int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if(!stack.empty() && stack.peek() == '?') {
                // pop ?
                stack.pop();
                char fir = stack.pop();
                // pop ;
                stack.pop();
                char sec = stack.pop();

                if(c == 'T') stack.push(fir);
                else stack.push(sec);
            }
            else {
                stack.push(c);
            }
        }

        return String.valueOf(stack.peek());

    }
}
