import java.util.Arrays;
import java.util.List;

public class Solution {
    public int findMinDifference(List<String> timePoints) {
        int minutes[] = new int[timePoints.size()];

        int i = 0;
        for(String s: timePoints) {
            String arr[] = s.split(":");
            int hour = Integer.valueOf(arr[0]);
            int min = Integer.valueOf(arr[1]);
            minutes[i] = 60 * hour + min;
            i++;
        }

        Arrays.sort(minutes);

        int min = Integer.MAX_VALUE;

        for(int j = 1; j < minutes.length; j++) {
            int diff = minutes[j] - minutes[j - 1];
            if(diff > 720) diff = 1440 - diff;
            min = min < diff ? min : diff;
        }

        int diff = minutes[minutes.length - 1] - minutes[0];

        if(diff > 720) diff = 1440 - diff;
        min = min < diff ? min : diff;

        return min;

    }
}
