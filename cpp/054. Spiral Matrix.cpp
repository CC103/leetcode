class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> ret;
        if(matrix.empty() || matrix[0].empty())
            return ret;
        //initialize the index range
        int m = matrix.size();
        int n = matrix[0].size();
        int num = m * n;
        int i = 0;
        int k = 0;
        while(k < num){
            int j = i;
            while(j < n - i){
                ret.push_back(matrix[i][j++]);
                k++;
            }
            if(k == num)
                break;
            j = i + 1;
            while(j < m - i){
                ret.push_back(matrix[j++][n - 1 - i]);
                k++;
            }
            if(k == num)
                break;
            j = n - 2 - i;
            while(j > i){
                ret.push_back(matrix[m - 1 - i][j--]);
                k++;
            }
            if(k == num)
                break;
            j = m - 1 - i;
            while(j > i){
                ret.push_back(matrix[j--][i]);
                k++;
            }
            i++;
        }
        return ret;
    }
};
