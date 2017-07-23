public class Solution {
    public int hammingDistance(int x, int y) {
        if (x == y) return 0;

        int arr1[] = new int[32];
        int arr2[] = new int[32];

        for (int i = 0; i < 32; i++) {
            arr1[i] = x & 1;
            x >>= 1;
            arr2[i] = y & 1;
            y >>= 1;
        }

        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (arr1[i] != arr2[i]) count++;
        }

        return count;
    }
}
