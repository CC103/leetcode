import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String s = "";
        for(char c: path.toCharArray()) {
            if(c == '/') {
                if(s.equals("..")){
                    if(!stack.empty()) stack.pop();
                }
                else if(!s.equals(".") && s.length() != 0) stack.push(s);
                s = "";
            }
            else {
                s += c;
            }
        }

        if(s.equals("..")){
            if(!stack.empty()) stack.pop();
        }
        else if(!s.equals(".") && s.length() != 0) stack.push(s);


        if(stack.empty()) return "/";
        String res = "";
        while(!stack.empty()) {
            res = "/" + stack.pop() + res;
        }
        return res;
    }
}
