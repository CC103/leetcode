import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int nthUglyNumber(int n) {
        int uglyNumber[] = new int[n];
        uglyNumber[0] = 1;
        int a = 0, b = 0, c = 0;
        for(int i = 1; i < n; i++) {
            int val1 = uglyNumber[a] * 2;
            int val2 = uglyNumber[b] * 3;
            int val3 = uglyNumber[c] * 5;
            int ith = threeMin(val1, val2, val3);
            if(val1 == ith) a++;
            if(val2 == ith) b++;
            if(val3 == ith) c++;
            uglyNumber[i] = ith;
        }
        return uglyNumber[n - 1];

    }

    public int threeMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
