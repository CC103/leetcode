class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int>> res;
        vector<int> cur;
        map<int, int> m;
        sort(candidates.begin(), candidates.end());
        for(int i : candidates){
            if(m.find(i) == m.end())
                m[i] = 1;
            else
                m[i]++;
        }
        int sum = 0;
        backtrack(res, cur, m, sum, target);
        return res;
    }
    void backtrack(vector<vector<int>> &res, vector<int> &cur, map<int, int> &m, int &sum, int target){
        if(!cur.empty()){
            sum += cur.back();
            if(sum == target){
                res.push_back(cur);
                return;
            }
            if(sum > target)
                return;
        }
        for(auto & i : m){
            if(i.second <= 0)
                continue;
            cur.push_back(i.first);
            i.second--;
            backtrack(res, cur, m, sum, target);
            sum -= cur.back();
            cur.pop_back();
            i.second++;
        }
    }
};
