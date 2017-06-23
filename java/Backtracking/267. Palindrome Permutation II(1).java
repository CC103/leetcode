// TLE

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> permutaions = new ArrayList<>();
        boolean isUsed[] = new boolean[s.length()];
        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        s = String.valueOf(arr);

        permutation(permutaions, "", s, 0, isUsed);

        List<String> res = new ArrayList<>();
        for(String str: permutaions) {
            if(isPalindrome(str)) res.add(str);
        }

        return res;

    }

    public void permutation(List<String> res, String temp, String s, int start, boolean[] isUsed) {
        if(temp.length() == s.length()) {
            res.add(temp);
            return;
        }

        for(int i = 0; i < s.length(); i++) {
            if(isUsed[i]) continue;
            if(i > 0 && s.charAt(i) == s.charAt(i - 1) && !isUsed[i - 1]) continue;
            isUsed[i] = true;
            permutation(res, temp + s.charAt(i), s, i + 1, isUsed);
            isUsed[i] = false;
        }
    }

    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
