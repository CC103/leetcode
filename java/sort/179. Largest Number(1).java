import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public String largestNumber(int[] nums) {
        List<String> l = new ArrayList<>();
        l.sort(Comparator.naturalOrder());

        String arr[] = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Comparator comp = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1);
            }
        };

        Arrays.sort(arr, comp);

        StringBuilder sb = new StringBuilder();
        for(String s: arr) {
            sb.append(s);
        }

        String res = sb.toString();
        if(res.charAt(0) == '0') return "0";
        return res;

    }
}
