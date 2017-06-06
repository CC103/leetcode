// HashSet
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for(int i: nums) {
            if(hashSet.contains(i)) {
                return true;
            }
            else hashSet.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int nums[] = {9, 9, 9};
    }
}
