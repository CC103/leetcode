// updated version
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        while (!set.contains(n)) {
            set.add(n);
            n = digitSquare(n);
        }
        return n == 1;

    }

    public int digitSquare(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
