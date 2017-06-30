import java.util.Arrays;

public class Solution {
    public int nextGreaterElement(int n) {
        String s = n + "";
        char arr[] = s.toCharArray();


        char min = arr[arr.length - 1];
        int index = -1;

        for(int r = arr.length - 2; r >= 0; r--) {
            if(arr[r] < min) {
                index = r;
                char c = arr[r];
                arr[r] = min;
                arr[arr.length - 1] = c;
                break;

            }
        }

        if(index == -1) return -1;

        Arrays.sort(arr, index + 1, arr.length);

        String num = new String(arr);

        return Integer.valueOf(num);

    }

}
