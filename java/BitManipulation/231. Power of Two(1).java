public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
            if (count > 1) return false;
        }
        return count == 1;
    }
}
