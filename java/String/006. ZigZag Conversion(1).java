public class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1) return s;
        StringBuilder sbs[] = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        int round = 2 * numRows - 2;
        for(int i = 0; i < s.length(); i++) {
            int n = i % round;
            if(n < numRows) sbs[n].append(s.charAt(i));
            else sbs[2 * numRows - n - 2].append(s.charAt(i));
        }

        String res = "";
        for(StringBuilder sb: sbs) {
            res += sb.toString();
        }

        return res;

    }
}
