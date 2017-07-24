public class Solution {
    public boolean isPowerOfFour(int num) {
        int index = - 1;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & 1) == 1) {
                count++;
                if (count > 1) return false;
                index = i;
            }
            num >>= 1;
        }

        return index % 2 == 0;
    }
}
