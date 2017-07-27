public class TicTacToe {
    int size;
    int[] player1Row;
    int[] player1Col;
    int[] player1Diag;
    int[] player2Row;
    int[] player2Col;
    int[] player2Diag;


    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        size = n;
        player1Row = new int[n];
        player1Col = new int[n];
        player1Diag = new int[2];
        player2Row = new int[n];
        player2Col = new int[n];
        player2Diag = new int[2];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (player == 1) {
            player1Row[row]++;
            if (player1Row[row] == size) return 1;
            player1Col[col]++;
            if (player1Col[col] == size) return 1;

            if (row == col) {
                player1Diag[0]++;
                if (player1Diag[0] == size) return 1;
            }

            if (row + col == size - 1) {
                player1Diag[1]++;
                if (player1Diag[1] == size) return 1;
            }

        }
        else {
            player2Row[row]++;
            if (player2Row[row] == size) return 2;
            player2Col[col]++;
            if (player2Col[col] == size) return 2;

            if (row == col) {
                player2Diag[0]++;
                if (player2Diag[0] == size) return 2;
            }

            if (row + col == size - 1) {
                player2Diag[1]++;
                if (player2Diag[1] == size) return 2;
            }
        }

        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
