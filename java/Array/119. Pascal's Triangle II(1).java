import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        while(rowIndex >= 0) {
            row.add(0, 1);
            for(int i = 1; i < row.size() - 1; i++) {
                row.set(i, row.get(i) + row.get(i + 1));
            }
            rowIndex--;
        }

        return row;

    }
}
