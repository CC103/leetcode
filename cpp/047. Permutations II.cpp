class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> cur;
        map<int, int> m;
        for(int i : nums){
            if(m.find(i) == m.end())
                m[i] = 1;
            else
                m[i]++;
        }
        int size = nums.size();
        backtrack(res, cur, m, size);
        return res;
    }
    void backtrack(vector<vector<int>> &res, vector<int> &cur, map<int, int> &m, int &size){
        if(cur.size() == size){
            res.push_back(cur);
            return;
        }
        for(auto &i : m){
            if(i.second <= 0)
                continue;
            cur.push_back(i.first);
            i.second--;
            backtrack(res, cur, m, size);
            cur.pop_back();
            i.second++;
        }
    }
};
