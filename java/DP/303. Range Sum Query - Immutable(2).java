import java.util.ArrayList;
import java.util.List;

public class NumArray {

    public NumArray(int[] nums) {

        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        sums = nums;

    }

    public int sumRange(int i, int j) {
        if(i == 0) return sums[j];

        return sums[j] - sums[i - 1];

    }

    private int[] sums = null;
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
