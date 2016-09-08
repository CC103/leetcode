class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        if(board.empty() || board[0].empty())
            return false;
        if(word.empty())
            return false;
        int m = board.size();
        int n = board[0].size();
        bool flag = false;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                flag = search(board, i, j, word);
                if(flag)
                    return true;
            }
        }
        return false;
    }
    bool search(vector<vector<char>>& board, int m, int n, string& word){
        if(word.empty())
            return true;
        if(m >= board.size() || n >= board[0].size() || m < 0 || n < 0)
            return false;
        if(board[m][n] != word[0])
            return false;
        char temp = board[m][n];
        board[m][n] = ' ';
        string curWord = word.substr(1);
        bool ret = search(board, m + 1, n, curWord) || search(board, m - 1, n, curWord) 
            || search(board, m, n + 1, curWord) || search(board, m, n - 1, curWord);
        board[m][n] = temp;
        return ret;
    }


};
