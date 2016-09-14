class Solution {
public:
    int longestSubstring(string s, int k) {
        if(k == 1)
            return s.size();
        if(k > s.size())
            return 0;
        int maxLen = 0;
        for(int i = 0; i < s.size(); i++){
            int count[26] = {0};
            for(int j = i; j < s.size(); j++){
                int maxOfSubstr = INT_MAX;
                count[s[j] - 'a']++;
                for(int p = 0; p < 26; p++){
                    // 子串中存在的字符的最小出现次数
                    if(count[p] != 0){
                        maxOfSubstr = count[p] < maxOfSubstr ? count[p] : maxOfSubstr;
                    }
                }
                if(maxOfSubstr >= k){
                    int substrLen = j - i + 1;
                    maxLen = maxLen > substrLen ? maxLen : substrLen; 
                }
            }
        }
        return maxLen;
    }
};
