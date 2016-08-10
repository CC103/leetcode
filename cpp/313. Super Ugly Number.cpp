/*
Core idea: 
Every ugly number is constructed from multiply a previous ugly number by one of the primes in the list
*/
class Solution {
public:
    int nthSuperUglyNumber(int n, vector<int>& primes) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        vector<int> k(n);
        k[0] = 1;
        //save the current position of each prime 
        int m = primes.size();
        vector<int> cur(m, 0);
        //save the temporary value
        vector<int> temp(m);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++)
                temp[j] = k[cur[j]] * primes[j];
            int min = temp[0];
            for(int it : temp){
                if(it < min)
                    min = it;
            }
            for(int j = 0; j < m; j++){
                if(min == temp[j])
                    cur[j]++;
            }
            k[i] = min;
        }
        return k[n - 1];
    }
};
