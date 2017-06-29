import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.startsWith("++", i)) res.add(s.substring(0, i) + "--" + s.substring(i + 2));
        }

        return res;
    }
}
