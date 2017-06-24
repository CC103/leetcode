public class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 0) return 0;
        int l = 0, r = citations.length - 1, mid;
        int index = 0;

        while(l < r) {
            // bias to right
            mid = (r + l + 1) / 2;
            int num = citations.length - mid;
            index = Math.max(index, Math.min(num, citations[mid]));

            if(citations[mid] <= num) l = mid;
            else r = mid - 1;
        }
        index = Math.max(index, Math.min(citations.length - l, citations[l]));
        return index;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int a[] = {1,2,3};
        s.hIndex(a);


    }
}
