public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int result[] = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int a = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int p1 = i + j, p2 = i + j + 1;
                int sum = a + result[p2];

                result[p2] += sum % 10;
                result[p1] += sum / 10;
            }
        }

        // skip leading zero
        int i = 0;
        while(i < result.length && result[i] == 0) {
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for(; i < result.length; i++) {
            sb.append(result[i]);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.multiply("0", "0");

    }
}
