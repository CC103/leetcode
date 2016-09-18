class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int>> ret;
        vector<int> instance;
        sort(candidates.begin(), candidates.end());
        backtrack(ret, instance, target, 0, candidates);
        return ret;
    }
    void backtrack(vector<vector<int>> &ret, vector<int> &instance, int target, int start, vector<int> &candidates){
        if(target == 0){
            ret.push_back(instance);
            return;
        }
        else{
            for(int i = start; i < candidates.size(); i++){
                if(candidates[i] > target){
                    return;
                }
                else{
                    instance.push_back(candidates[i]);
                    backtrack(ret, instance, target - candidates[i], i + 1, candidates);
                    instance.pop_back();
                    while(i + 1 < candidates.size() && candidates[i + 1] == candidates[i]){
                        i++;
                    }
                }
            }

        }
    }
};
