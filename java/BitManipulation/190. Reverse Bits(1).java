public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int bits[] = new int[32];
        for (int i = 0; i < 32; i++) {
            bits[i] = n & 1;
            n >>>= 1;
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] == 1) res += 1 << (31 - i);
        }

        return res;
    }
}
