import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < ppid.size(); i++) {
            map.putIfAbsent(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }

        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(kill);

        while (!queue.isEmpty()) {
            int val = queue.poll();
            res.add(val);

            if (!map.containsKey(val)) continue;
            queue.addAll(map.get(val));
        }

        return res;
    }

}
