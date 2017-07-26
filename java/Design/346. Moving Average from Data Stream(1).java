import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    Queue<Integer> queue;
    double sum = 0;
    int size;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        queue.offer(val);
        int fir = 0;
        if (queue.size() > size) fir = queue.poll();
        sum = sum - fir + val;
        return sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
