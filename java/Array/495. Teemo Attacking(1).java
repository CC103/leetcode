public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int time = 0;
        for(int i = 0; i < timeSeries.length; i++) {
            int d = duration;
            if(i == timeSeries.length - 1) return time + d;

            int start = timeSeries[i];
            int end = timeSeries[i + 1];
            while(d > 0 && start < end) {
                time++;
                start++;
                d--;
            }
        }

        return 0;

    }
}
