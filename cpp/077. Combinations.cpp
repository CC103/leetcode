class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> res;
        vector<int> cur;
        if(n < k || n < 1 || k < 1)
            return res;
        gen(res, cur, n, k);
        return res;

    }
    void gen(vector<vector<int>> &res, vector<int> &cur, int n, int k){
        if(cur.size() == k){
            res.push_back(cur);
            return;
        }
        int start;
        if(cur.empty())
            start = 0;
        else
            start = cur.back();
        for(int i = start + 1; i <= n; i++){
            cur.push_back(i);
            gen(res, cur, n, k);
            cur.pop_back();
        }
    }
};
