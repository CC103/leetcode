import java.util.ArrayList;
import java.util.List;

public class NumArray {

    public NumArray(int[] nums) {
        int sum = 0;

        for(int i = 0; i < nums.length; i++) {
            sums.add(sum + nums[i]);
            sum += nums[i];
        }

    }

    public int sumRange(int i, int j) {
        if(i == 0) return sums.get(j);

        return sums.get(j) - sums.get(i - 1);

    }

    private List<Integer> sums = new ArrayList<>();
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
