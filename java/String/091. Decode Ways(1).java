// TLE
public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                if(s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') return 0;
            }
        }

        return DP(s);
    }

    public int DP(String s) {
        if(s.length() == 0) return 1;

        if (s.charAt(0) == '0') return 0;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                if(s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') return 0;
            }
        }

        if (s.length() == 1) return 1;
        int num = Integer.valueOf(s.substring(0, 2));
        if(num == 10 || num == 20) return DP(s.substring(2));
        if (num > 26 ) return DP(s.substring(1));
        return DP(s.substring(1)) + DP(s.substring(2));


    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.numDecodings("10");
        System.out.println(s.DP("10"));
    }
}
