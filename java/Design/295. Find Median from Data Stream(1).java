import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {

    Queue<Long> small, large;

    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<>();
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        large.add((long) num);
        small.add(-large.poll());
        if (large.size() < small.size()) large.add(-small.poll());
    }

    public double findMedian() {
        if (large.size() > small.size()) return large.peek();
        else return (large.peek() - small.peek()) / 2.0;

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
