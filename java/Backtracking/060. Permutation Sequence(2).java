import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> digit = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            digit.add(i);
        }

        StringBuilder sb = new StringBuilder();
        int len = n;
        // 边界归属前一个区域
        k--;
        while(sb.length() != len) {
            int fac = factorial(n - 1);
            int index = k / fac;
            sb.append(digit.get(index));
            digit.remove(index);
            n--;
            k = k % fac;
        }

        return sb.toString();

    }

    public int factorial(int x) {
        int res = 1;
        for(int i = 2; i <= x; i++) {
            res *= i;
        }
        return res;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getPermutation(1,1));
    }

}
