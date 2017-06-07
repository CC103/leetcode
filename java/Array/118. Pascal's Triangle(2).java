// Space O(n)
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> row = new ArrayList<>();

        for(int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for(int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            triangle.add(row);
        }
        return triangle;
    }

    public static void main(String arg[]) {
        Solution s = new Solution();
        s.generate(3);
    }
}
