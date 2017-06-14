public class Solution {
    public String getHint(String secret, String guess) {
        int map[] = new int[10];
        for(char c: secret.toCharArray()) {
            map[c - '0']++;
        }

        int bulls = 0;
        for(int i = 0; i < guess.length(); i++) {
            if(guess.charAt(i) == secret.charAt(i)) bulls++;
        }

        int cows = 0;
        for(char c: guess.toCharArray()) {
            if(map[c - '0'] > 0) {
                cows++;
                map[c - '0']--;
            }
        }
        cows -= bulls;

        return bulls + "A" + cows + "B";

    }
}
