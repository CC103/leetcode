class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<int> hash(strs.size(), 0);
        vector<vector<string>> res;
        if(strs.empty())
            return res;
        for(int i = 0; i < strs.size(); i++){
            for(int j = 0; j < strs[i].size(); j++){
                hash[i] += int(strs[i][j] * int(strs[i][j])) * int(strs[i][j]) * int(strs[i][j]); 
            }
        }
        for(int i : hash)
            cout << i << " ";
        vector<int> flag(strs.size(), 0);
        for(int i = 0; i < hash.size(); i++){
            if(flag[i] == 1)
                continue;
            vector<string> cur;
            cur.push_back(strs[i]);
            flag[i] = 1;
            for(int j = i + 1; j < hash.size(); j++){
                if(hash[j] == hash[i]){
                    cur.push_back(strs[j]);
                    flag[j] = 1;
                }
            }
            res.push_back(cur);
        }
        return res;
    }
};
