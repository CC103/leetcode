class Solution {
public:
    int countBattleships(vector<vector<char>>& board) {
        if(board.empty()) return 0;
        int num = 0;
        int m = board.size();
        int n = board[0].size();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // find the head of battle ship
                if((board[i][j] == 'X') && ((j - 1 >= 0 && board[i][j - 1] == '.') || j == 0) && (i == 0 || (i - 1 >= 0 && board[i - 1][j] == '.'))){
                    num++;
                }
            }
        }
        return num;
    }
};
