class Solution {
public:
    string toHex(int num) {
        unsigned n = unsigned(num);
        int hex[8];
        for(int i = 0; i < 8; i++){
            // 00..001111
            hex[i] = n & 15;
            n = n >> 4;
        }
        string ret;
        bool flag = true;
        for(int i = 7; i >= 0; i--){
            // remove the leading zero
            if(flag){
                if(hex[i] == 0)
                    continue;
                else
                    flag = false;
            }
            if(hex[i] < 10){
                ret.push_back(hex[i] + '0');
            }
            else{
                ret.push_back(hex[i] - 10 + 'a');
            }
        }
        if(ret.empty())
            return "0";
        return ret;

    }
};
