//Stack
import java.util.Stack;

public class Solution {
    public int majorityElement(int[] nums) {
        Stack stack = new Stack();
        for(Integer i : nums) {
            if(stack.empty()) stack.push(i);
            else {
                if(!i.equals(stack.peek())) {
                    stack.pop();
                }
                else stack.push(i);
            }
        }
        return (int)stack.peek();
    }
}
