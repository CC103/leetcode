class Solution {
public:
    int rangeBitwiseAnd(int m, int n) {
        int temp = m;
        for(int i = m + 1; i <= n; i++){
            temp &= i; 
        }
        return temp;
    }
};
