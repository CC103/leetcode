import java.util.Arrays;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length < 2) return 0;

        Arrays.sort(intervals, (a, b) -> {
            return a.start - b.start;
        });

        Interval temp = intervals[0];
        int remove = 0;

        for (int i = 1; i < intervals.length; i++) {

            if(intervals[i].start < temp.end) {
                remove++;
                temp = temp.end < intervals[i].end ? temp : intervals[i];
            }
        }

        return remove;
    }
}
