class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        if(grid.empty()) return 0;
        int perimeter = 0;
        for(int i = 0; i < grid.size(); i++){
            for(int j = 0; j < grid[0].size(); j++){
                if(grid[i][j] == 1){
                    perimeter = perimeter + 4 - insideSlides(grid, i, j);
                }
            }
        }
        return perimeter;
        
    }
    int insideSlides(vector<vector<int>>& grid, int m, int n){
        int num = 0;
        if(m - 1 >= 0 && grid[m - 1][n] == 1) num++;
        if(n - 1 >= 0 && grid[m][n - 1] == 1) num++;
        if(m + 1 < grid.size() && grid[m + 1][n] == 1) num++;
        if(n + 1 < grid[0].size() && grid[m][n + 1] == 1) num++;
        return num;
    }
};
