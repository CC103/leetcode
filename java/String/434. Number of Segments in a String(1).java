public class Solution {
    public int countSegments(String s) {
        int num = 0;
        boolean isSeg = false;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!= ' ') {
                isSeg = true;
            }

            else {
                if(isSeg) {
                    num++;
                    isSeg = false;
                }
            }
        }

        if(isSeg) num++;

        return num;
    }
}
