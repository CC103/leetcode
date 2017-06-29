public class Solution {
    public String reverseWords(String s) {
        if(s.length() == 0) return "";
        int l = 0, r = 0;
        char arr[] = s.toCharArray();

        while(r < arr.length) {
            if(arr[r] == ' ' && arr[l] != ' ') {
                reverse(arr, l, r - 1);
                r++;
                l = r;
            }
            else if(arr[r] == ' ' && arr[l] == ' ') {
                r++;
                l = r;
            }

            else r++;
        }

        if(arr[r - 1] != ' ') reverse(arr, l, r - 1);

        return new String(arr);

    }

    public void reverse(char[] arr, int start, int end) {
        while(start < end) {
            char c = arr[start];
            arr[start] = arr[end];
            arr[end] = c;

            start++;
            end--;
        }

    }


}
