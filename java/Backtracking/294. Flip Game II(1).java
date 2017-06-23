public class Solution {
    public boolean canWin(String s) {
        if(s.length() < 2) return false;
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.startsWith("++", i)) {
                if(!canWin(s.substring(0, i) + "--" + s.substring(i + 2))) return true;
            }
        }

        return false;

    }
}
