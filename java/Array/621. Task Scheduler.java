import java.util.Arrays;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        char[] frequency = new char[26];
        for (char c: tasks) {
            frequency[c - 'A']++;
        }

        Arrays.sort(frequency);
        int i = 25;
        while (i >= 0 && frequency[i] == frequency[25]) {
            i--;
        }

        return Math.max(tasks.length, (frequency[25] - 1) * (n + 1) + 25 - i);
    }
}
