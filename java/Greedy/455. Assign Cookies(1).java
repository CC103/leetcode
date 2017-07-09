import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int j = 0;
        for(int i = 0; i < s.length; i++) {
            if(j == g.length) return j;

            if(s[i] >= g[j]) j++;
        }

        return j;

    }
}
