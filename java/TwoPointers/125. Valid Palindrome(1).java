public class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;

        char arr[] = new char[s.length()];
        s = s.toLowerCase();

        int i = 0;
        for(char c: s.toCharArray()) {
            if(Character.isLetterOrDigit(c)) arr[i++] = c;
        }

        int l = 0, r = i - 1;
        while(l < r) {
            if(arr[l++] != arr[r--]) return false;
        }

        return true;
    }
}
