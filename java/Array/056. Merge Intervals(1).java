// Brute Force
import java.util.*;

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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if(intervals.size() == 0) return res;

        // Sort intervals by their start
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        int start = intervals.get(0).start, end = intervals.get(0).end;

        for(int i = 1; i < intervals.size(); i++) {
            Interval thisInterval = intervals.get(i);
            if(thisInterval.start <= end) {
                end = thisInterval.end > end ? thisInterval.end : end;
            }
            else{
                res.add(new Interval(start, end));
                start = thisInterval.start;
                end = thisInterval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}
