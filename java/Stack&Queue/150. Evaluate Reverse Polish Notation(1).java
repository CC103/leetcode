import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            switch (s) {
                case "+":
                    int a = stack.pop();
                    int b = stack.pop();
                    int c = a + b;
                    stack.push(c);
                    break;
                case "-":
                    int a1 = stack.pop();
                    int b1 = stack.pop();
                    int c1 = b1 - a1;
                    stack.push(c1);
                    break;
                case "*":
                    int a2 = stack.pop();
                    int b2 = stack.pop();
                    int c2 = a2 * b2;
                    stack.push(c2);
                    break;
                case "/":
                    int a3 = stack.pop();
                    int b3 = stack.pop();
                    int c3 = b3 / a3;
                    stack.push(c3);
                    break;

                default:
                    int d = Integer.valueOf(s);
                    stack.push(d);
            }
        }

        return !stack.empty() ? stack.pop() : 0;

    }
}
