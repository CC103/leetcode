/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n, mid;

        while(l < r) {
            mid = l + (r - l) / 2;

            if(isBadVersion(mid)) {
                if(mid == 1) return 1;
                if(!isBadVersion(mid - 1)) return mid;

                r = mid;
            }
            else l = mid + 1;
        }

        return l;

    }
}
