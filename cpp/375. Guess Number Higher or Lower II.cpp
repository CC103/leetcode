class Solution {
public:
    int getMoneyAmount(int n) {
        vector<int> row(n + 1, 0);
        vector<vector<int>> table(n + 1, row);
        return DP(table, 1, n);
    }
    int DP(vector<vector<int>> &table, int start, int end){
        if(start >= end)
            return 0;
        // default = 0?
        if(table[start][end] != 0)
            return table[start][end];
        int ret = INT_MAX;
        for(int i = start; i <= end; i++){
            int temp = i + max(DP(table, start, i - 1), DP(table, i + 1, end));
            ret = min(ret, temp);
        }
        table[start][end] = ret;
        return ret;
    }
};
