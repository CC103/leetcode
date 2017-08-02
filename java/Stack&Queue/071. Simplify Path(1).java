import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] arr = path.split("/");
        for (String s: arr) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            }
            else if (!s.equals(".") && s.length() != 0) {
                stack.push(s);
            }
        }
        if (stack.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop()).insert(0, '/');
        }

        return sb.toString();
    }
}
