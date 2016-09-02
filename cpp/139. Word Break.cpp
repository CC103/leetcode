class Solution {
public:
    bool wordBreak(string s, unordered_set<string>& wordDict) {
        if(wordDict.size() == 0)
            return false;
        //dp[i] shows whether we can arrive in s[i]
        vector<bool> dp(s.size() + 1, false);
        //we can start from the first element
        dp[0] = true;
        //of course we can arrive in s[0], so we set i = 1 to determine if we could arrive in s[1]
        for(int i = 1; i <= s.size(); i++){
            for(int j = i - 1; j >= 0; j--){
                //start from a position we can arrive in
                if(dp[j]){
                    string word = s.substr(j, i - j);
                    if(wordDict.find(word) != wordDict.end()){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.size()];
    }
};
