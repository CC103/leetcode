public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int row[][] = new int[9][9];
        int col[][] = new int[9][9];
        int sub[][] = new int[9][9];

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    int val = board[i][j] - '1';
                    if(row[i][val] == 1 || col[j][val] == 1 || sub[i / 3 * 3 + j / 3][val] == 1) return false;

                    row[i][val] = 1;
                    col[j][val] = 1;
                    sub[i / 3 * 3 + j / 3][val] = 1;
                }
            }
        }
        return true;

    }
}
