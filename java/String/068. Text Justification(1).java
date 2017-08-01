import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        int start = 0;

        while (start < words.length) {
            // find start and end word for each line, end is exclusive
            int numOfChar = words[start].length();
            int end = start + 1;
            while (end < words.length) {
                if (numOfChar + 1 + words[end].length() > maxWidth) break;
                numOfChar += 1 + words[end].length();
                end++;
            }

            StringBuilder sb = new StringBuilder();

            // last line or there is only one word is this line
            if (end == words.length || end == start + 1) {
                for (int i = start; i < end; i++) {
                    sb.append(words[i]).append(' ');
                }
                sb.deleteCharAt(sb.length() - 1);
                while (sb.length() < maxWidth) sb.append(' ');
            }
            else {
                int numOfGaps = end - start - 1;
                // arrange spaces
                int spaces = (maxWidth - numOfChar) / numOfGaps;
                int remainer = (maxWidth - numOfChar) % numOfGaps;

                for (int i = start; i < end; i++) {
                    sb.append(words[i]);
                    // there is no spaces after last word
                    if (i == end - 1) continue;
                    // 之所以在这里是j<=， 是因为前面的numOfChar是包含了一个空格的，所以在这要把这个空格加上，即多添加一个
                    for (int j = 0; j <= (spaces + ((i - start) < remainer ? 1 : 0)); j++) {
                        sb.append(' ');
                    }
                }
            }
            lines.add(sb.toString());
            start = end;
        }

        return lines;
    }
}
