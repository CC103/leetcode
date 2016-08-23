class Solution {
public:
    vector<vector<string>> partition(string s) {
        vector<vector<string>> ret;
        vector<string> path;
        if(s.size() == 0)
            return ret;
        backtrack(ret, path, 0, s); 
        return ret;
    }

    void backtrack(vector<vector<string>> &ret, vector<string> &path, int start, string &s){
        if(start == s.size()){
            ret.push_back(path);
            return;
        }
        for(int i = start; i < s.size(); i++){
            if(isPalindrome(s, start, i)){
                path.push_back(s.substr(start, i - start + 1));
                backtrack(ret, path, i + 1, s);
                path.pop_back();
            }
        }
    }

    bool isPalindrome(string &s, int start, int end){
        while(start < end){
            if(s[start++] != s[end--])
                return false;
        }
        return true;
    }
};
