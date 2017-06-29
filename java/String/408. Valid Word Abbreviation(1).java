public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int next = 0;
        int num = 0;

        for(int i = 0; i < abbr.length(); i++) {
            char c = abbr.charAt(i);
            if(!Character.isDigit(c)) {
                next += num;
                num = 0;

                if(next >= word.length()) return false;

                if(word.charAt(next) != abbr.charAt(i)) return false;
                else next++;
            }
            else {
                if(num == 0 && c == '0') return false;
                num = num * 10 + c - '0';
            }
        }

        if(num != 0) next += num;

        if(next == word.length()) return true;

        return false;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.validWordAbbreviation("abbreviation", "a10n");
    }
}
