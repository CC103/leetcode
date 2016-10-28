class Solution {
public:
    vector<pair<int, int>> pacificAtlantic(vector<vector<int>>& matrix) {
        vector<pair<int, int>> ret;
        if(matrix.empty()) return ret;
        vector<bool> row(matrix[0].size(), false);
        // avoid duplication of checking
        vector<vector<bool>> ifChecked(matrix.size(), row);
        for(int i = 0; i < matrix.size(); i++){
            for(int j = 0; j < matrix[0].size(); j++){
                vector<vector<bool>> copy1(ifChecked);
                vector<vector<bool>> copy2(ifChecked);
                if(ifAtlantic(matrix, copy1, i, j) && ifPacific(matrix, copy2, i, j)){
                    pair<int, int> cordinates(i, j);
                    ret.push_back(cordinates);
                }
            }
        }
        return ret;
    }
    bool ifAtlantic(vector<vector<int>>& matrix, vector<vector<bool>>& ifChecked, int i, int j){
        ifChecked[i][j] = true;
        if(i == 0 || j == 0){
            return true;
        }
        else{
            if(!ifChecked[i - 1][j] && matrix[i - 1][j] <= matrix[i][j]){
                if(ifAtlantic(matrix, ifChecked, i - 1, j)) return true;
            }
            if(!ifChecked[i][j - 1] && matrix[i][j - 1] <= matrix[i][j]){
                if(ifAtlantic(matrix, ifChecked, i, j - 1)) return true;
            }
            if(i + 1 < matrix.size() && !ifChecked[i + 1][j] && matrix[i + 1][j] <= matrix[i][j]){
                if(ifAtlantic(matrix, ifChecked, i + 1, j)) return true;
            }
            if(j + 1 < matrix[0].size() && !ifChecked[i][j + 1] && matrix[i][j + 1] <= matrix[i][j]){
                if(ifAtlantic(matrix, ifChecked, i, j + 1)) return true;
            }
        }
        return false;
    }
    bool ifPacific(vector<vector<int>>& matrix, vector<vector<bool>>& ifChecked, int i, int j){
        ifChecked[i][j] = true;
        if(i == matrix.size() - 1 || j == matrix[0].size() - 1){
            return true;
        }
        else{
            if(i - 1 >= 0 && !ifChecked[i - 1][j] && matrix[i - 1][j] <= matrix[i][j]){
                if(ifPacific(matrix, ifChecked, i - 1, j)) return true;
            }
            if(j - 1 >= 0 && !ifChecked[i][j - 1] && matrix[i][j - 1] <= matrix[i][j]){
                if(ifPacific(matrix, ifChecked, i, j - 1)) return true;
            }
            if(!ifChecked[i + 1][j] && matrix[i + 1][j] <= matrix[i][j]){
                if(ifPacific(matrix, ifChecked, i + 1, j)) return true;
            }
            if(!ifChecked[i][j + 1] && matrix[i][j + 1] <= matrix[i][j]){
                if(ifPacific(matrix, ifChecked, i, j + 1)) return true;
            }
        }
        return false;
    }
};
