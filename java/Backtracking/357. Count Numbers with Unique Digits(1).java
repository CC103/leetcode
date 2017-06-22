public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        if(n > 10) n = 10;
        int nums[] = new int[11];
        nums[1] = 10;
        nums[2] = 81;
        for(int i = 3, j = 8; i <= n; i++, j--) {
            nums[i] = nums[i - 1] * j;
        }

        int res = 0;


        while(n > 0) {
            res += nums[n--];
        }

        return res;

    }
}
