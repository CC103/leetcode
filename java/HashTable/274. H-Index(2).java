import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int arr[] = new int[len + 1];

        for(int i: citations) {
            if(i > len) arr[len]++;
            else arr[i]++;
        }

        int num = 0;
        for(int i = len; i >= 0; i--) {
            num += arr[i];
            if(num >= i) return i;
        }

        return 0;

    }
}
