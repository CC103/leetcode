public class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 0) return 0;
        int l = 0, r = citations.length - 1, mid;
        while(l <= r) {
            mid = (r + l) / 2;
            int num = citations.length - mid;

            if(citations[mid] == num) return num;

            if(citations[mid] > num) r = mid - 1;
            else l = mid + 1;
        }

        return citations.length - (r + 1);


    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int a[] = {1,2,3};
        s.hIndex(a);


    }
}
