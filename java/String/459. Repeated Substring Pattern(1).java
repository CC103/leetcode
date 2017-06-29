public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s.length() == 0) return false;

        for(int subSize = 1; subSize <= s.length() / 2; subSize++) {
            if(s.length() % subSize != 0) continue;

            int subNum = s.length() / subSize;
            String substr = s.substring(0, subSize);

            StringBuilder sb = new StringBuilder();
            while(subNum-- > 0) {
                sb.append(substr);
            }

            if(sb.toString().equals(s)) return true;
        }

        return false;
    }
}
