import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public String reverseVowels(String s) {
        String vowel = "aeiouAEIOU";
        char arr[] = s.toCharArray();

        int l = 0, r = s.length() - 1;
        while(l < r) {
            while(l < r && !vowel.contains(arr[l] + "")) l++;
            while(r > l && !vowel.contains(arr[r] + "")) r--;

            if(l == r) break;

            char c = arr[l];
            arr[l] = arr[r];
            arr[r] = c;
            l++;
            r--;
        }
        return new String(arr);

    }
}
