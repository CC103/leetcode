import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> map = new HashSet<>();
        int category = 0;
        for(int i: candies) {
            if(!map.contains(i)) {
                category++;
                map.add(i);
            }
        }

        return Math.min(category, candies.length / 2);

    }
}
