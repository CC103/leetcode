class Solution {
public:
    int rangeBitwiseAnd(int m, int n) {
        int degree = 0;
        while(m != n){
        	m >>= 1;
        	n >>= 1;
        	degree++;
        }
        //now m equals n
        return n << degree;
    }
};
