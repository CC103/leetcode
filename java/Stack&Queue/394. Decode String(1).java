import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c != ']') stack.push(c + "");
            else {
                String item = "";
                while(!stack.peek().equals("[")) item = stack.pop() + item;
                System.out.println("item: " + item);
                // pop the [
                stack.pop();
                String num = "";
                while(!stack.empty() && Character.isDigit(stack.peek().charAt(0))) num = stack.pop() + num;
                int k = Integer.valueOf(num);
                System.out.println("k: " + k);
                String unit = item;
                while(k-- > 1) {
                    item += unit;
                }
                stack.push(item);
            }
        }

        if(stack.empty()) return "";
        String res = "";
        while(!stack.empty()) res = stack.pop() + res;
        return res;
    }
    public static void main(String arg[]) {
        Solution s = new Solution();
        String ss = "3[a]2[bc]";
        System.out.println(s.decodeString(ss));
    }
}
