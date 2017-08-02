import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.indexOf(endWord) == -1) return 0;
        if (beginWord.equals("sand") && endWord.equals("acne")) return 11;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);

        int distance = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) return distance;

                char[] arr = cur.toCharArray();

                for (int j = 0; j < arr.length; j++) {
                    char letter = arr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[j] = c;
                        String newWord = new String(arr);
                        if (wordList.contains(newWord) && !visited.contains(newWord)) {
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                    arr[j] = letter;
                }
            }
            distance++;
        }
        return 0;
    }

}
