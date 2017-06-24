public class Solution {
    public boolean isPerfectSquare(int num) {
        int l = 1, r = num, mid;
        while(l <= r) {
            mid = l + (r - l) / 2;
            if(num % mid == 0 && mid == num / mid) return true;
            if(mid < num / mid) l = mid + 1;
            else r = mid - 1;
        }

        return false;

    }
}
