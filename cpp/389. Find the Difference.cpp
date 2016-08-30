class Solution {
public:
    char findTheDifference(string s, string t) {
        int hashS[26] = {0};
        int hashT[26] = {0};
        char ret;
        for(auto c : s){
            hashS[c - 'a']++;
        }
        for(auto c : t){
            int i = c - 'a';
            hashT[i]++;
            if(hashT[i] > hashS[i]){
                ret = char(i + 'a');
                break;
            }
        }
        return ret;
    }
};
