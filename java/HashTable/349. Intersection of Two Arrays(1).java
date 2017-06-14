import java.util.*;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> l = new HashSet<>();

        for(int i: nums1) {
            set.add(i);
        }

        for(int i: nums2) {
            if(set.contains(i)) l.add(i);
        }

        int res[] = new int[l.size()];
        int j = 0;
        for(int i: l) {
            res[j++] = i;
        }


        return res;

    }
}
