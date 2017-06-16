public class Solution {
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if(haystack.substring(i, i + len).equals(needle)) return i;
        }
        return -1;
    }
}
