public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int map[] = new int[26];
        if(s2.length() < s1.length()) return false;

        for(int i = 0; i < s1.length(); i++) {
            map[s1.charAt(i) - 'a']++;
            map[s2.charAt(i) - 'a']--;
        }
        if(isAnagram(map)) return true;

        for(int j = 0, i = s1.length(); i < s2.length(); i++, j++) {
            map[s2.charAt(j) - 'a']++;
            map[s2.charAt(i) - 'a']--;
            if(isAnagram(map)) return true;

        }

        return false;
    }

    public boolean isAnagram(int[] nums) {
        for(int i: nums) {
            if(i != 0) return false;
        }
        return true;
    }
}
