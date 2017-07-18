import java.util.*;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);

        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node, copy);

        for (UndirectedGraphNode neighbor: node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbor));
        }


        return copy;
    }

    // original node with copy
    private Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

}
