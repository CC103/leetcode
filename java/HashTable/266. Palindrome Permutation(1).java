public class Solution {
    public boolean canPermutePalindrome(String s) {
        int map[] = new int[128];

        for(char c: s.toCharArray()) {
            map[c]++;
        }

        boolean odd = false;
        for(int i: map) {
            if(i % 2 == 1) {
                if(odd) return false;
                odd = true;
            }
        }

        return true;

    }
}
