class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int hash[500] = {0};
        int start = 0, end = 0, len = 0;
        while(end < s.size()){
            if(hash[s[end]] == 0){
                hash[s[end]] = 1;
                end++;
            }
            else{
                len = max(len, end - start);
                hash[s[start]] = 0;
                start++;
            }
        }
        len = max(len, end - start);
        return len;
    }
};
