public class Solution {
    public int countPrimes(int n) {
        int count = 0;
        // false represents prime
        boolean ifPrimes[] = new boolean[n];
        for(int i = 2; i < n; i++) {
            if(!ifPrimes[i]) {
                count++;
                for(int j = 2; j * i < n; j++) {
                    ifPrimes[j * i] = true;
                }
            }
        }
        return count;

    }
}
