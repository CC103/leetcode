public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0;
        int l = s.length();

        while (rows > 0) {
            start += cols;

            if (s.charAt(start % l) == ' ') {
                // remove the space
                start++;
            }
            else {
                // start will less than 0 when the word's length is larger than cols
                while (start > 0 && s.charAt((start - 1) % l) != ' ') start--;
            }

            rows--;
        }

        return start / s.length();

    }
}
