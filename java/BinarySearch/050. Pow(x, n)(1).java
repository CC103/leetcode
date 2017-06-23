public class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;

        if(n < 0) {
            if(n == Integer.MIN_VALUE) {
                x = 1 / (x * x);
                n = Integer.MAX_VALUE / 2 + 1;
            }
            else {
                x = 1 / x;
                n = -n;
            }
        }

        if(n % 2 == 0) return myPow(x * x, n / 2);
        return x * myPow(x * x, n / 2);

    }
}
