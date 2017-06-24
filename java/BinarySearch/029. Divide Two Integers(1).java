public class Solution {
    public int divide(int dividend, int divisor) {
        // overflow
        if(dividend == 0) return 0;
        if(divisor == 0) return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(divisor == 1) return dividend;

        int sigh = 1;
        if(dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) sigh = -1;

        long m = Math.abs(dividend), n = Math.abs(divisor);
        if(m < 0) m *= -1;
        if(n < 0) n *= -1;

        if(m < n) return 0;

        long sum = n;
        int count = 1;
        int res = 0;

        while(m >= sum + sum) {
            sum += sum;
            count += count;
            m -= sum;
            res += count;
        }

        sum = n;
        while(m >= sum) {
            res += 1;
            m -= sum;
        }

        return sigh * res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(-2147483648, 2));

    }
}
