// ETL
public class Solution {
    public int countPrimes(int n) {
        int count = 0;
        for(int i = 2; i < n; i++) {
            boolean flag = true;
            for(int j = 2; j <= i / 2; j++) {
                if(i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) count++;
        }
        return count;

    }
}
