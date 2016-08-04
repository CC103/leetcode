class Solution {
public:
    int rangeBitwiseAnd(int m, int n) {
        int degree = 0;
        while(m < n){
        	n &= (n - 1);
        }
        return n;
    }
};
