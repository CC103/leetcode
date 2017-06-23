import java.util.*;

public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int odd = 0;
        for (int i : map.values()) {
            if (i % 2 == 1) odd++;
        }
        if (odd > 1) return res;

        String mid = "";
        List<Character> halfStr = new ArrayList<>();

        for (char c : map.keySet()) {
            if (map.get(c) % 2 == 1) mid += c;
            int n = map.get(c) / 2;
            while (n-- > 0) {
                halfStr.add(c);
            }
        }

        boolean isUsed[] = new boolean[halfStr.size()];
        permutation(res, new StringBuilder(), mid, halfStr, isUsed);

        return res;

    }

    public void permutation(List<String> res, StringBuilder sb, String mid, List<Character> s, boolean[] isUsed) {
        if (sb.length() == s.size()) {
            res.add(sb + mid + sb.reverse());
            sb.reverse();
            return;
        }

        for (int i = 0; i < s.size(); i++) {
            if (isUsed[i]) continue;
            if (i > 0 && s.get(i) == s.get(i - 1) && !isUsed[i - 1]) continue;

            isUsed[i] = true;
            sb.append(s.get(i));
            permutation(res, sb, mid, s, isUsed);
            sb.deleteCharAt(sb.length() - 1);
            isUsed[i] = false;
        }
    }

}
