import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length() > s.length()) return res;

        int pFre[] = new int[26];
        for(char c: p.toCharArray()) {
            pFre[c - 'a']++;
        }

        int lenP = p.length();
        int sFre[] = new int[26];

        for(int i = 0; i < lenP; i++) {
            sFre[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s.length() - lenP + 1; i++) {
            boolean flag = true;
            for(int j = 0; j < 26; j++) {
                if(sFre[j] != pFre[j]) {
                    flag = false;
                    break;
                }
            }
            if(flag) res.add(i);

            if(i == s.length() - lenP) continue;;

            sFre[s.charAt(i) - 'a']--;
            sFre[s.charAt(i + lenP) - 'a']++;
        }

        return res;

    }
}
