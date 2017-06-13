// O(n^2)
public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int res[] = new int[length];

        for(int[] triplet: updates) {
            int start = triplet[0];
            int end = triplet[1];
            int inc = triplet[2];
            for(int i = start; i <= end; i++) {
                res[i] += inc;
            }
        }

        return res;

    }
}
