public class Solution {
    public boolean checkRecord(String s) {
        int absent = 0;
        int late = 0;
        for(char c: s.toCharArray()) {
            if(c == 'A') {
                absent++;
                late = 0;
            }
            if(c == 'L') late++;

            if(c == 'P') late = 0;

            if(absent > 1 || late > 2) return false;
        }

        return true;
    }
}
