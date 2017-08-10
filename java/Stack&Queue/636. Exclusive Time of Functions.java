import java.util.*;

public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int times[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;

        for (String log: logs) {
            String[] arr = log.split(":");
            int id = Integer.valueOf(arr[0]);
            int time = Integer.valueOf(arr[2]);

            if (!stack.isEmpty()) times[stack.peek()] += time - prevTime;
            prevTime = time;

            if (arr[1].equals("start")) stack.push(id);
            else {
                times[stack.pop()]++;
                prevTime++;
            }
        }
        return times;
    }
}
