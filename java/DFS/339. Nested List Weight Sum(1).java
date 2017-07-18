/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int sum[] = new int[1];
        for (NestedInteger n: nestedList) {
            sumNode(1, sum, n);
        }

        return sum[0];

    }

    public void sumNode(int depth, int[] sum, sumNestedInteger n) {
        if (n.isInteger()) {
            sum[0] += depth * n.getInteger();
        }

        else {
            List<NestedInteger> l = n.getList();
            for (NestedInteger m: l) {
                sumNode(depth + 1, sum, m);
            }
        }
    }
}
