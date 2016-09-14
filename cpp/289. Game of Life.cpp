class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        int m = board.size();
        int n = m ? board[0].size() : 0;
        // using two bit represent two states separately, this round and next round
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int count = 0;
                for(int p = max(i - 1, 0); p < min(i + 2, m); p++){
                    for(int q = max(j - 1, 0); q < min(j + 2, n); q++){
                        // including board[i][j] itself
                        count += board[p][q] & 1;
                    }
                }
                if(count == 3 || count - board[i][j] == 3){
                    // make 00->10 and 01->11 (binary)
                    board[i][j] |= 2;
                }
            }
        }
        // update the state
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] >>= 1;
            }
        }
    }
};
