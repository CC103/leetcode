import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> res =  new ArrayList<>(1);
            res.add(0);
        }

        List<Set<Integer>> pairs = new ArrayList<>(n);
        for (int i = 0; i < n; i++) pairs.add(new HashSet<>());

        for (int[] edge: edges) {
            pairs.get(edge[0]).add(edge[1]);
            pairs.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (pairs.get(i).size() == 1) leaves.add(i);
        }

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf: leaves) {
                int parent = pairs.get(leaf).iterator().next();
                pairs.get(parent).remove(leaf);
                if (pairs.get(parent).size() == 1) newLeaves.add(parent);
            }

            leaves = newLeaves;
        }

        return leaves;
    }
}
