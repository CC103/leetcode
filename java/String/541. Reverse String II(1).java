public class Solution {
    public String reverseStr(String s, int k) {
        char arr[] = s.toCharArray();

        int next = 0;
        while(next < s.length()) {
            int left = s.length() - next;

            if(left <= k) {
                reverse(arr, next, arr.length - 1);
                return new String(arr);
            }

            reverse(arr, next, next + k - 1);
            next = next + k + k;

        }

        return new String(arr);

    }

    public void reverse(char arr[], int start, int end) {
        while(start < end) {
            char c = arr[start];
            arr[start] = arr[end];
            arr[end] = c;
            start++;
            end--;
        }
    }
}
