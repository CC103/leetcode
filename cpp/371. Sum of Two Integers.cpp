class Solution {
public:
    int getSum(int a, int b) {
        //there is carry on
        int c = a & b;
        while(c){
            int d = a ^ b;
            int e = c << 1;
            a = d;
            b = e;
            c = a & b;
        }
        return a ^ b;
    }
};
