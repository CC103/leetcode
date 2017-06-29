public class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length() <= 0) return true;

        // all capitals
        if(word.toUpperCase().equals(word)) return true;

        return word.substring(1).toLowerCase().equals(word.substring(1));


    }
}
