// TLE

import java.util.*;

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        for(String word: words) {
            if(set.contains(word)) continue;
            set.add(word);
            char boardCopy[][] = new char[m][n];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) boardCopy[i][j] = board[i][j];
            }

            if(exist(boardCopy, word)) res.add(word);
        }
        return res;

    }

    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || word.length() == 0) return false;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(search(board, word, i, j, 1)) return true;
                }
            }
        }
        return false;

    }

    public boolean search(char[][] board, String word, int i, int j, int c) {
        if(c == word.length()) return true;
        char temp = board[i][j];
        board[i][j] = ' ';

        // left
        if(j - 1 >= 0 && board[i][j - 1] == word.charAt(c)) {
            if(search(board, word, i, j - 1, c + 1)) return true;
        }

        // right
        if(j + 1 < board[0].length && board[i][j + 1] == word.charAt(c)) {
            if(search(board, word, i, j + 1, c + 1)) return true;
        }


        // up
        if(i - 1 >= 0 && board[i - 1][j] == word.charAt(c)) {
            if(search(board, word, i - 1, j, c + 1)) return true;
        }

        // down
        if(i + 1 < board.length && board[i + 1][j] == word.charAt(c)) {
            if(search(board, word, i + 1, j, c + 1)) return true;
        }

        board[i][j] = temp;
        return false;
    }
}
