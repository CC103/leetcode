import java.util.*;

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();

        for(int[] building: buildings) {
            height.add(new int[]{building[0], -building[2]});
            height.add(new int[]{building[1], building[2]});

        }

        Collections.sort(height, (int[] a, int[] b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
        });

        Queue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        queue.offer(0);

        int preMax = 0;
        int curr;
        for(int[] h: height) {
            if(h[1] < 0) {
                queue.offer(-h[1]);
            }
            else{
                queue.remove(h[1]);
            }

            curr = queue.peek();
            if(curr != preMax) res.add(new int[]{h[0], queue.peek()});
            preMax = curr;
        }

        return res;

    }

}
