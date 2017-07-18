import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int outDegree[] = new int[numCourses];
        ArrayList[] followCourses = new ArrayList[numCourses];

        for (int i = 0; i < followCourses.length; i++) {
            followCourses[i] = new ArrayList();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            outDegree[prerequisites[i][0]]++;
            // add follow up courses
            followCourses[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < outDegree.length; i++) {
            if (outDegree[i] == 0) queue.add(i);
        }

        int count = 0;
        int order[] = new int[numCourses];
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            order[count] = cur;
            count++;

            for (int i = 0; i < followCourses[cur].size(); i++) {
                int followup = (int)followCourses[cur].get(i);
                outDegree[followup]--;

                // meet all pre-requisites
                if (outDegree[followup] == 0) queue.add(followup);
            }
        }

        return count == numCourses ? order : new int[0];
    }
}
