public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i: nums) {
            xor ^= i;
        }

        xor &= -xor;

        int res[] = new int[2];
        for (int i: nums) {
            if ((i & xor) == 0) res[0] ^= i;
            else res[1] ^= i;
        }

        return res;
    }
}
