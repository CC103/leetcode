public class Solution {
    public int findLonelyPixel(char[][] picture) {
        if(picture == null || picture.length == 0) return 0;
        int count = 0;
        int m = picture.length;
        int n = picture[0].length;

        int row[] = new int[m];
        int col[] = new int[n];

        for(int i = 0; i < m; i++) {
            boolean flag = false;
            for(int j = 0; j < n; j++) {
                if(picture[i][j] == 'B') {
                    if(flag) {
                        flag = false;
                        break;
                    }
                    else flag = true;
                }
            }
            if(flag) row[i] = 1;
        }

        for(int i = 0; i < n; i++) {
            boolean flag = false;
            for(int j = 0; j < m; j++) {
                if(picture[j][i] == 'B') {
                    if(flag) {
                        flag = false;
                        break;
                    }
                    else flag = true;
                }
            }
            if(flag) col[i] = 1;
        }

        for(int i = 0; i < m; i++) {
            if(row[i] == 0) continue;
            for(int j = 0; j < n; j++){
                if(col[j] == 0) continue;

                if(picture[i][j] == 'B') count++;
            }
        }

        return count;

    }
}
