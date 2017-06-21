import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), 0, s);
        return res;
    }

    public void backtrack(List<List<String>> res, List<String> temp, int start, String s) {
        if(start == s.length()) res.add(new ArrayList<>(temp));

        for(int i = start + 1; i <= s.length(); i++) {
            String subStr = s.substring(start, i);
            if(isPalindrome(subStr)) {
                temp.add(subStr);
                backtrack(res, temp, i, s);
                temp.remove(temp.size() - 1);
            }
        }
    }


    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() -1;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
