public class Solution {
    public int[] findPermutation(String s) {
        int num[] = new int[s.length() + 1];
        for (int i = 0; i < num.length; i++) {
            num[i] = i + 1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') continue;
            else {
                int start = i;
                while(i + 1< s.length() && s.charAt(i + 1) == 'D') {
                    i++;
                }
                int end = i + 1;
                reverse(num, start, end);
            }
        }

        return num;

    }

    public int[] reverse(int[] num, int start, int end) {
        while(start < end) {
            int temp = num[start];
            num[start] = num[end];
            num[end] = temp;
            start++;
            end--;
        }

        return num;
    }
}
