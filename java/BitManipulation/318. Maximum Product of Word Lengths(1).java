public class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;

        int letters[] = new int[words.length];
        for (int i = 0; i < letters.length; i++) {
            String s = words[i];

            for (int j = 0; j < s.length(); j++) {
                // 1 means there is specific letter in this string
                letters[i] |= 1 << (s.charAt(j) - 'a');
            }
        }

        int max = 0;
        for (int i = 0; i < letters.length; i++) {
            for (int j = i + 1; j < letters.length; j++) {
                if ((letters[i] & letters[j]) == 0) {
                    int pro = words[i].length() * words[j].length();
                    max = Math.max(max, pro);
                }
            }
        }

        return max;
    }
}
