import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int nextGreaterElement(int n) {
        String s = n + "";
        char charDigits[] = s.toCharArray();
        int digits[] = new int[charDigits.length];

        for(int i = 0; i < charDigits.length; i++) {
            digits[i] = charDigits[i] - '0';
        }

        Arrays.sort(digits);
        boolean isUsed[] = new boolean[digits.length];
        List<Integer> res = new ArrayList<>();
        permutation(res, 0, digits.length, digits, isUsed);

        int min = Integer.MAX_VALUE;
        for(int i: res) {
            if(i > n && i < min) min = i;
        }

        if(min == Integer.MAX_VALUE) return -1;

        return min;

    }

    public void permutation(List<Integer> res, int temp, int count, int[] digits,  boolean[] isUsed) {
        if(count == 0) {
            res.add(temp);
            return;
        }

        for(int i = 0; i < digits.length; i++) {
            if(isUsed[i]) continue;
            if(i > 0 && digits[i] == digits[i - 1] && !isUsed[i - 1]) continue;

            isUsed[i] = true;
            permutation(res, temp * 10 + digits[i], count - 1, digits, isUsed);
            isUsed[i] = false;
        }
    }
}
