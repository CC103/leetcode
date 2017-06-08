// hashTable
public class Solution {
    public int missingNumber(int[] nums) {
        int hashTable[] = new int[nums.length + 1];
        for(int i: nums) {
            hashTable[i] = 1;
        }
        for(int i = 0; i < hashTable.length; i++) {
            if(hashTable[i] == 0) return i;
        }

        return -1;
    }
}
