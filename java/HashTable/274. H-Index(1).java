import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int hindex = 0, len = citations.length;
        for(int i = len - 1; i >= 0; i--) {
            while(i != 0 && citations[i - 1] == citations[i]) i--;
            int h = Math.min(citations[i], len - i);
            hindex = Math.max(h, hindex);
        }

        return hindex;

    }
}
