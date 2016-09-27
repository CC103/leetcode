class Solution {
public:
    string toHex(int num) {
        unsigned n = unsigned(num);
        cout << n << endl;
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
                if(hex[i] == 10)
                    ret.push_back('a');
                else if(hex[i] == 11)
                    ret.push_back('b');
                else if(hex[i] == 12)
                    ret.push_back('c');
                else if(hex[i] == 13)
                    ret.push_back('d');
                else if(hex[i] == 14)
                    ret.push_back('e');
                else if(hex[i] == 15)
                    ret.push_back('f');
                else
                    cout << "error hex number" << endl;
            }
        }
        if(ret.empty())
            return "0";
        return ret;

    }
};
