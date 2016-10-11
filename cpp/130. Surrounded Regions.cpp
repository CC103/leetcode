class Solution {
public:
    void solve(vector<vector<char>>& board) {
            if(board.empty()) return;
            int m = board.size();
            int n = board[0].size();
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(i == 0 || i == m - 1 || j == 0 || j == n - 1){
                        if(board[i][j] == 'O'){
                            board[i][j] = 'Y';
                            search(board, i, j);
                        }
                    }
                }
            }
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j] == 'O'){
                        board[i][j] = 'X';
                    }
                }
            }
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j] == 'Y'){
                        board[i][j] = 'O';
                    }
                }
            }

    }
    void search(vector<vector<char>>& board, int i, int j){
        if(i - 1 > 0 && board[i - 1][j] == 'O'){
            board[i - 1][j] = 'Y';
            search(board, i - 1, j);
        }
        if(i + 1 < board.size() - 1 && board[i + 1][j] == 'O'){
            board[i + 1][j] = 'Y';
            search(board, i + 1, j);
        }
        if(j - 1 > 0 && board[i][j - 1] == 'O'){
            board[i][j - 1] = 'Y';
            search(board, i, j - 1);
        }
        if(j + 1 < board[0].size() - 1 && board[i][j + 1] == 'O'){
            board[i][j + 1] = 'Y';
            search(board, i, j + 1);
        }
    }

};
