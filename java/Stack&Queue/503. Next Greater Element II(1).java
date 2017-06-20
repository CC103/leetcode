import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[nums.length];
        Arrays.fill(res, -1);
        int n = nums.length;

        for(int i = 0; i < 2 * n; i++) {
            while(!stack.empty() && nums[i % n] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % n];
            }

            if(i < n) stack.push(i);
        }

        return res;
    }
}
