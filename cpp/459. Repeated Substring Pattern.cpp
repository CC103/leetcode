class Solution {
public:
    bool repeatedSubstringPattern(string str) {
        if(str.empty()) return false;
        int len = 1;
        while(len <= str.size() / 2){
            bool flag = true;
            string pattern = str.substr(0, len);
            if(str.size() % len != 0){
                len++;
                continue;
            }
            for(int i = 0; i < str.size(); i++){
                int pos = i % len;
                if(pattern[pos] != str[i]){
                    flag = false;
                    break;
                }
            }
            if(flag) return true;
            len++;
        }
        return false;
    }
};
