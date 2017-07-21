public class Solution {
    public int findCircleNum(int[][] M) {
        boolean isVisited[] = new boolean[M.length];
        int count = 0;

        for (int i = 0; i < M.length; i++) {
            if (!isVisited[i]) {
                dfs(M, isVisited, i);
                count++;
                isVisited[i] = true;
            }
        }
        return count;

    }

    public void dfs(int[][] M, boolean[] isVisited, int i) {
        for (int j = 0; j < M[0].length; j++) {
            if (M[i][j] == 1 && !isVisited[j]) {
                isVisited[j] = true;
                dfs(M, isVisited, j);
            }
        }
    }

}
