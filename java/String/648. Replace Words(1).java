import java.util.Comparator;
import java.util.List;

public class Solution {
    public String replaceWords(List<String> dict, String sentence) {

        // sort by length
        dict.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < dict.size(); j++) {
                if (word.startsWith(dict.get(j))){
                    words[i] = dict.get(j);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s: words) {
            sb.append(s).append(' ');
        }

        return sb.toString().trim();
    }
}
