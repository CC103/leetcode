public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int pointers[] = new int[primes.length];
        int superUglyNum[] = new int[n];
        superUglyNum[0] = 1;

        for(int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;

            for(int j = 0; j < primes.length; j++) {
                int val = primes[j] * superUglyNum[pointers[j]];
                if(val < min) min = val;
            }
            superUglyNum[i] = min;

            for(int j = 0; j < pointers.length; j++) {
                int val = primes[j] * superUglyNum[pointers[j]];
                if(val == min) pointers[j]++;
            }
        }

        return superUglyNum[n - 1];

    }
}
