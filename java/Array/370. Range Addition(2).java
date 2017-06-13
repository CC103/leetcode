// O(K+M)
public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int res[] = new int[length];

        for(int[] triplet: updates) {
            int start = triplet[0];
            int end = triplet[1];
            int inc = triplet[2];
            res[start] += inc;
            if(end < length - 1) res[end + 1] -= inc;
        }

        int sum = 0;
        for(int i = 0; i < length; i++){
            sum += res[i];
            res[i] = sum;
        }

        return res;

    }
}
