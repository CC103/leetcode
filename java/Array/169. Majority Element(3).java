//Bit Manipulation
public class Solution {
    public int majorityElement(int[] nums) {
        int bit[] = new int[32];
        for(int i: nums) {
            for(int j = 0; j < 32; j++) {
                if((i >> (31 - j) & 1) == 1) bit[j]++;
            }
        }
        int len = nums.length / 2;
        int majority = 0;
        for(int i = 0; i < 32; i++) {
            if(bit[i] > len) {
                // 2^(31-i) == 1 << (31 - i)
                majority += 1 << (31 - i);
            }
        }

        return majority;
    }
}
