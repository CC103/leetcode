public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";

        StringBuilder sb = new StringBuilder();

        int next = 0;
        if(strs[0].length() == 0) return "";
        char c = strs[0].charAt(0);

        while(true) {
            for(int i = 0; i < strs.length; i++) {
                if(next >= strs[i].length() || strs[i].charAt(next) != c) return sb.toString();
            }

            sb.append(c);
            next++;
            if(next >= strs[0].length()) return sb.toString();
            c = strs[0].charAt(next);
        }

    }
}
