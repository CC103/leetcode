public class Solution {
    public boolean isHappy(int n) {
        int loop = 20;
        while(loop > 0) {
            int sum = 0;
            while(n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            if(sum == 1) return true;
            n = sum;
            loop--;
        }
        return false;

    }
}
