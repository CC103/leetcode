// TLE
import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // if wordList doesn't contain endWord, impossible
        int index = wordList.indexOf(endWord);
        if (index == -1) return 0;

        wordList.add(endWord);
        Queue<String> queue = new LinkedList<>();
        // begin and end
        int distance = 1;

        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) return distance;

                transform(cur, wordList, queue);
            }
            distance++;
        }
        return 0;
    }

    public void transform(String word, List<String> wordList, Queue<String> queue) {
        int index = wordList.indexOf(word);
        // avoid duplicate
        if (index != -1) wordList.remove(index);

        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < 26; j++) {
                String newWord = word.substring(0, i) + (char)('a' + j) + word.substring(i + 1);
                if (wordList.contains(newWord)) {
                    index = wordList.indexOf(newWord);
                    wordList.remove(index);
                    queue.offer(newWord);
                }
            }
        }
    }
}
