import org.omg.CORBA.INTERNAL;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;

        // sort interval by start time, the first one starts first
        Arrays.sort(intervals, (Interval a, Interval b) -> a.start - b.start);

        // keep the head of heap is the one which ends first
        PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.length, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });

        heap.offer(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            Interval room = heap.poll();
            if(intervals[i].start >= room.end) {
                room.end = intervals[i].end;
                heap.offer(room);
            }
            else {
                heap.offer(room);
                heap.offer(intervals[i]);
            }
        }

        return heap.size();


    }
}
