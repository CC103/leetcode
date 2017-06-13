public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;

        if(word1.equals(word2)) {
            int l = -1;
            for(int i = 0; i < words.length; i++) {
                if(words[i].equals(word1)){
                    if(l == -1) l = i;
                    else {
                        min = Math.min(min, i - l);
                        l = i;
                    }
                }
            }

        }
        else {
            int l = -1, r = -1;
            for(int i = 0; i < words.length; i++) {
                if(words[i].equals(word1)) l = i;
                else if(words[i].equals(word2)) r = i;

                if(l != -1 && r != -1) min = Math.min(min, Math.abs(l - r));
            }
        }

        return min;
    }
}
