public class Solution {
    public char findTheDifference(String s, String t) {
        int sFre[] = new int[26];
        int tFre[] = new int[26];

        for(int i = 0; i < s.length(); i++) {
            sFre[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++) {
            tFre[t.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++) {
            if(sFre[i] != tFre[i]) return (char) ('a' + i);
        }
        return t.charAt(t.length() - 1);
    }
}
