public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int l = -1, r = -1, min = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) l = i;
            if(words[i].equals(word2)) r = i;
            if(l != -1 && r != -1) {
                min = Math.min(min, Math.abs(l - r));
            }
        }
        return min;

    }
}
