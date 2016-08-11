class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> res;
        vector<int> cur;
        sort(candidates.begin(), candidates.end());
        int sum = 0;
        gen(candidates, res, cur, sum, target);
        return res;
    }
    void gen(vector<int> &candidates, vector<vector<int>> &res, vector<int> &cur, int &sum, int target){
        for(int i : candidates){
            //avoid duplicates
            if(!cur.empty())
                if(i < cur.back())
                    continue;
            sum += i;
            if(sum > target){
                sum -= i;
                return;
            }
            if(sum == target){
                cur.push_back(i);
                res.push_back(cur);
                cur.pop_back();
                sum -= i;
                return;
            }
            cur.push_back(i);
            gen(candidates, res, cur, sum, target);
            cur.pop_back();
            sum -= i;
        }
    }
};
