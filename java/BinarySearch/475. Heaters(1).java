import java.util.Arrays;

public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int radius = 0;

        for(int house: houses) {
            int index = Arrays.binarySearch(heaters, house);

            if(index < 0) index = -(index + 1);

            int leftDis = index > 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int rightDis = index != heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

            int dis = Math.min(leftDis, rightDis);
            radius = Math.max(radius, dis);
        }

        return radius;


    }
}
