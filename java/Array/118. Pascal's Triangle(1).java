// Space O(n^2)
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for(int i = 0; i < numRows; i++) {
            int size = i + 1;
            List<Integer> row = new ArrayList<>(size);

            row.add(1);
            for(int j = 1; j < size - 1; j++) {
                row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
            }
            if(size != 1) row.add(1);

            triangle.add(row);
        }
        return triangle;
    }

    public static void main(String arg[]) {
        Solution s = new Solution();
        s.generate(3);
    }
}
