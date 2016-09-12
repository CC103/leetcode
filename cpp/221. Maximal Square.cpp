class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int max = 0;
        if(matrix.empty() || matrix[0].empty())
            return max;
        for(int i = 0; i < matrix.size(); i++){
            for(int j = 0; j < matrix[0].size(); j++){
                if(matrix[i][j] == '1')
                    dp(matrix, i, j, 1, max);
            }
        }
        
        return max * max;
    }
    //max is slide length of the largest square
    void dp(vector<vector<char>>& matrix, int m, int n, int slideLength, int &max){
        max = slideLength > max ? slideLength : max;
        int i = slideLength;
        for(int i = 0; i < slideLength; i++){
            if(n + slideLength >= matrix[0].size() || matrix[m + i][n + slideLength] == '0')
                return;
        }
        for(int i = 0; i <= slideLength; i++){
            if(m + slideLength >= matrix.size() || matrix[m + slideLength][n + i] == '0')
                return;
        }
        dp(matrix, m, n, slideLength + 1, max);
    }
};
