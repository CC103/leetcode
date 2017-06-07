import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> hashTable = new HashSet<>();
        int head = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i <= k) {
                if(hashTable.contains(nums[i])) return true;
                else hashTable.add(nums[i]);
            }
            else{
                hashTable.remove(nums[head]);
                head++;

                if(hashTable.contains(nums[i])) return true;
                else hashTable.add(nums[i]);
            }
        }
        return false;

    }
}
