/*
Core idea: 
Every ugly number is constructed from multiply a previous ugly number by one of the primes in the list
*/
class Solution {
public:
int nthSuperUglyNumber(int n, vector<int>& primes) {
        vector<int> index(primes.size(), 0);
        vector<int> ugly(n, INT_MAX);
        ugly[0] = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < primes.size(); j++) 
                ugly[i] = min(ugly[i], ugly[index[j]] * primes[j]);
            for(int j = 0; j < primes.size(); j++) 
                index[j] += (ugly[i] == ugly[index[j]] * primes[j]);
        }
        return ugly[n - 1];
}
};
