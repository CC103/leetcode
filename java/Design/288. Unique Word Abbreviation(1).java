import java.util.*;

public class ValidWordAbbr {
    Map<String, List<String>> map;

    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for (String s: dictionary) {
            if (s.length() == 0) continue;

            if (s.length() < 3) {
                List<String> l = new ArrayList();
                l.add(s);
                map.put(s, l);
            }

            int num = s.length() - 2;
            String abb = "" + s.charAt(0) + num + s.charAt(s.length() - 1);
            if (map.containsKey(abb)) map.get(abb).add(s);
            else {
                List<String> l = new ArrayList();
                l.add(s);
                map.put(abb, l);
            }
        }
    }

    public boolean isUnique(String word) {
        if (map.isEmpty()) {
            return true;
        }

        if (word.length() < 3) {
            return true;
        }
        int num = word.length() - 2;
        String abb = "" + word.charAt(0) + num + word.charAt(word.length() - 1);

        if (!map.containsKey(abb)) {
            return true;
        }
        if (map.get(abb).size() == 1 && map.get(abb).get(0).equals(word)) {
            return true;
        }
        return false;
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
