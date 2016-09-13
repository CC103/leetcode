class Solution {
public:
    bool isSubsequence(string s, string t) {
        if(s.empty())
            return true;
        if(t.empty())
            return false;
        int sIndex = 0;
        int tIndex = 0;
        for(; tIndex < t.size(); tIndex++){
            if(s[sIndex] == t[tIndex])
                sIndex++;
            if(sIndex == s.size())
                return true;
        }

        return false;
    }
};
