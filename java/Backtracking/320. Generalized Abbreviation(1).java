import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        DFS(res, "", 0, 0, word);
        return res;
    }

    public void DFS(List<String> res, String temp, int pos, int count, String word) {
        if(pos == word.length()) {
            temp += count > 0 ? count : "";
            res.add(temp);
        }

        else {
            // abbreviate it
            DFS(res, temp, pos + 1, count + 1, word);

            // keep it
            DFS(res, temp + (count > 0 ? count : "") + word.charAt(pos), pos + 1, 0, word);
        }
    }
}
