// Bit manipulation
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int hashTable[] = new int[1048576];
        List<String> res = new ArrayList<>();
        if(s.length() < 11) return res;

        int sum = 0;
        for(int i = 0; i < 10; i++) {
            sum <<= 2;
            char c = s.charAt(i);
            if(c == 'A') sum += 0;
            else if(c == 'C') sum += 1;
            else if(c == 'G') sum += 2;
            else sum += 3;
        }
        hashTable[sum] = 1;

        for(int i = 10; i < s.length(); i++) {
            char c = s.charAt(i);
            sum <<= 2;
            if(c == 'A') sum += 0;
            else if(c == 'C') sum += 1;
            else if(c == 'G') sum += 2;
            else sum += 3;

            sum &= 0xfffff;

            // Avoid duplication, only add the second time a number shows
            if(hashTable[sum] == 1) {
                res.add(s.substring(i - 9, i + 1));
                hashTable[sum] = 2;
            }
            else hashTable[sum]++;
        }
        return res;
    }

    public static void main(String[] args) {
        String a = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        Solution s = new Solution();
        s.findRepeatedDnaSequences(a);
    }
}
