class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        if(grid.empty() || grid[0].empty())
            return 0;
        int m = grid.size();
        int n = grid[0].size();
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    DFS(grid, i, j, m, n);
                }
            }
        }
        return count;
    }

    void DFS(vector<vector<char>>& grid, int i, int j, int &m, int &n){
        //grid[i][j] != '1'要放到最后，因为短路运算放在最后不会出现访问冲突
        if(i >= m || i < 0 || j >= n || j < 0 || grid[i][j] != '1' )
            return;
        cout << "f"<< endl;
        grid[i][j] == '0';
        if(i + 1 < m && grid[i + 1][j] == '1')
            DFS(grid, i + 1, j, m, n);
        if(i - 1 > 0 && grid[i - 1][j] == '1')
            DFS(grid, i - 1, j, m, n);
        if(j + 1 < n && grid[i][j + 1] == '1')
            DFS(grid, i, j + 1, m, n);
        if(j - 1 > 0 && grid[i][j - 1] == '1')
            DFS(grid, i, j - 1, m, n);
        return; 
    }
};
