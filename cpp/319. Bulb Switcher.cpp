#include <iostream>

class Solution {
public:
    int bulbSwitch(int n) {
        if(n == 0)
            return 0;
        int limit = 3;
        int a = 5;
        int b = 1;
        while(1){
            if(n <= limit)
                return b;
            else{
                 limit += a;
                 a += 2;
                 b++;
            }
        }
    }
};
