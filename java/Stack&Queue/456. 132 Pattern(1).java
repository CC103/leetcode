import java.util.Stack;

public class Solution {
    class Pair {
        int max, min;
        public Pair(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }

    public boolean find132pattern(int[] nums) {
        if(nums.length < 3) return false;
        Stack<Pair> stack = new Stack<>();

        for(int n: nums) {
            if(stack.empty() || n < stack.peek().min) stack.push(new Pair(n, n));
            if(n > stack.peek().min) {
                if(n < stack.peek().max) return true;
                if(n > stack.peek().max) {
                    Pair last = stack.pop();
                    last.max = n;
                    while(!stack.empty() && stack.peek().max < n) stack.pop();
                    if(!stack.empty() && n > stack.peek().min) return true;
                    stack.push(last);
                }
            }
        }

        return false;

    }
}
