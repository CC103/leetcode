import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char sigh = '+';

        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) num = num * 10 + s.charAt(i) - '0';

            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                if(sigh == '+') stack.push(num);
                else if(sigh == '-') stack.push(-num);
                else if(sigh == '*') stack.push(stack.pop() * num);
                else stack.push(stack.pop() / num);

                sigh = s.charAt(i);
                num = 0;
            }

        }

        int res = 0;
        while(!stack.empty()) {
            res += stack.pop();
        }

        return res;

    }
}
