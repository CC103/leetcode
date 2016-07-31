class Solution {
public:
    int numSquares(int n) {
    	//count [i] = the least number of perfect square numbers which sum to i
        vector<int> count(n + 1, INT_MAX);
        count[0] = 0;
        for(int i = 1; i <= n; i++){
        	//for each i, it must be the sum of some number (i - j*j) and a perfect square number j*j
        	for(int j = 1; j * j <= i; j++){
        		count[i] = min(count[i], count[i - j * j] + 1);
        	}
        }
        return count.back();

    }
};
