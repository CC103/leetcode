class Solution {
public:
    int base = 1337;
    int superPow(int a, vector<int>& b) {
        if(b.empty())
            return 1;
        int m = b.back();
        b.pop_back();
        return powMod(superPow(a, b), 10) * powMod(a, m) % base;
    }
    int powMod(int a, int b){
        a = a % base;
        int res = 1;
        while(b){
            res = (a * res) % base;
            b--;
        }
        return res;
    }
};
