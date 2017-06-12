// work when upper - lower < Integer.MAX_VALUE
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int hash[] = new int[upper - lower + 1];

        for(int i: nums) {
            int j = i - lower;
            if(j >= 0 || j < hash.length) hash[j] = 1;
        }

        List<String> res = new ArrayList<>();

        int l = 0, r = 0;

        while(r < hash.length) {

            if(hash[l] == 1) {
                l++;
                r = l;
                continue;
            }

            if(r == hash.length - 1 || hash[r + 1] == 1) {
                if(l == r) res.add((l + lower) + "");
                else res.add((l + lower) + "->" + (r + lower));
                l = r + 1;
                r = l;
            }
            else r++;
        }

        return res;
    }
}
