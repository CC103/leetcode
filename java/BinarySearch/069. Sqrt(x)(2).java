public class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        int l = 1, h = x, mid;

        while(l < h) {
            mid = l + (h - l) / 2;
            if(mid == x / mid) return mid;

            if(l == h - 1) return l;

            if(mid < x / mid) l = mid;

            else h = mid;


        }
        return l;

    }
}
