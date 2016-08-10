class Solution {
public:
    int nthUglyNumber(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        vector<int> k(n);
        int t2 = 0, t3 = 0, t5 = 0;
        k[0] = 1;
        for(int i = 1; i < n; i++){
            int T2 = 2 * k[t2], T3 = 3 * k[t3], T5 = 5 * k[t5];
            k[i] = min(T2, min(T3, T5));
            if(k[i] == T2)
                t2++;
            if(k[i] == T3)
                t3++;
            if(k[i] == T5)
                t5++;
        }
        return k[n - 1];
    }
};
