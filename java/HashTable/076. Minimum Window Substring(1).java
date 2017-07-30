public class Solution {
    public String minWindow(String s, String t) {
        int map[] = new int[128];
        // only character in t can be more than 0
        for (char c: t.toCharArray()) {
            map[c]++;
        }

        int  counter = t.length(), begin = 0, end = 0, head = 0, minLen = Integer.MAX_VALUE;

        while (end < s.length()) {
            // find a character in t, minus counter
            if (map[s.charAt(end++)]-- > 0) counter--;
            // find a valid window
            while (counter == 0) {
                // update minLen
                if (end - begin < minLen) {
                    head = begin;
                    minLen = end - begin;
                }
                // remove most left window element, make it invalid
                if (map[s.charAt(begin++)]++ == 0) counter++;
            }
        }

        if (minLen == Integer.MAX_VALUE) return "";
        return s.substring(head, head + minLen);

    }
}
