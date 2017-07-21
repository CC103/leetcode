import java.util.*;

public class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        if (words == null || words.length == 0) return sb.toString();

        // Initialization degree with 0
        for (String word: words) for (char c : word.toCharArray()) degree.put(c, 0);

        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];

            int len = Math.min(cur.length(), next.length());
            for (int j = 0; j < len; j++) {
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);

                if (c1 != c2) {
                    map.putIfAbsent(c1, new HashSet<>());
                    // avoid duplicate
                    if (!map.get(c1).contains(c2)) {
                        map.get(c1).add(c2);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        // largest character
        for (char c: degree.keySet()) {
            if (degree.get(c) == 0) queue.add(c);
        }

        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);


            if (!map.containsKey(c)) continue;

            // all characters smaller than c, degree minus 1
            for (char next: map.get(c)) {
                degree.put(next, degree.get(next) - 1);
                if (degree.get(next) == 0) queue.add(next);
            }
        }

        if (sb.toString().length() != degree.size()) return "";
        return sb.toString();
    }
}
