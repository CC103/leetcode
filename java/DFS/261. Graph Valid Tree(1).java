import java.util.Arrays;

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        int[] nums = new int[n];
        Arrays.fill(nums, -1);

        for (int i = 0; i < edges.length; i++) {
            int p1 = find(nums, edges[i][0]);
            int p2 = find(nums, edges[i][1]);
            // there will be a circle
            if (p1 == p2) return false;

            // one root point to another root
            // union
            nums[p1] = p2;
        }

        return true;

    }

    public int find(int[] nums, int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
}
