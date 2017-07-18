/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        int depth = 1;
        for (int i = 0; i < nestedList.size(); i++) {
            depth = Math.max(depth, getDepth(1, nestedList.get(i)));
            System.out.println(depth);
        }
        System.out.println(depth);

        int sum[] = new int[1];
        for (int i = 0; i < nestedList.size(); i++) {
            add(sum, depth, nestedList.get(i));
        }

        return sum[0];
    }

    public int getDepth(int depth, NestedInteger n) {
        if (n.isInteger()) return depth;

        List<NestedInteger> nestedList = n.getList();
        int max = depth;
        if (nestedList.size() != 0) max = depth + 1;

        for (int i = 0; i < nestedList.size(); i++) {
            if (!nestedList.get(i).isInteger())
                max = Math.max(max, getDepth(depth + 1, nestedList.get(i)));
        }

        return max;
    }

    public void add(int[] sum, int weight, NestedInteger n) {
        if (n.isInteger()) sum[0] += weight * n.getInteger();
        else {
            List<NestedInteger> nestedList = n.getList();
            for (int i = 0; i < nestedList.size(); i++) add(sum, weight - 1, nestedList.get(i));
        }
    }
}
