import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    class Pair {
        int x;
        int y;
        int sum;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
            sum = x + y;
        }
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new ArrayList<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> (a.sum - b.sum));
        for (int i: nums1) {
            for (int j: nums2) {
                queue.offer(new Pair(i, j));
            }
        }

        List<int[]> res = new ArrayList<>();
        while (k-- > 0) {
            if (queue.isEmpty()) break;
            Pair p = queue.poll();
            res.add(new int[]{p.x, p.y});
        }

        return res;
    }
}
