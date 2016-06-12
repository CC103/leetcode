#include<iostream>
#define INT_MAX     2147483647
#define INT_MIN     (-INT_MAX - 1)
class Solution {
public:
    int reverse(int x) {
        int result = 0;
        int n = 0;
        while(x != 0){
            n = x % 10;
            if(result > INT_MAX/10 || result < INT_MIN/10)
                return 0;
            result = result*10 + n;
            x = x/10;
        }
        return result;
    }
};
