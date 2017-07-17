// TLE

public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (kill == 0) return res;

        queue.add(kill);
        res.add(kill);

        while (!queue.isEmpty()) {
            int val = queue.poll();
            for (int i = 0; i < ppid.size(); i++) {
                if (ppid.get(i) == val) {
                    res.add(pid.get(i));
                    queue.add(pid.get(i));
                }
            }
        }

        return res;

    }
}
