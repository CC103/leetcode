public class Solution {

public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Queue<String> queue = new LinkedList<String>();
    queue.add(beginWord);
    int len=1;
    HashSet<String> set = new HashSet<String>(wordList);

    while(!queue.isEmpty()){
        int queueSize = queue.size();
        for(int i=0; i<queueSize; i++){
            String word = queue.poll();
            if(word.equals(endWord)) return len;
            else addToQueue(set, queue, word);
        }
        len++;
    }
    return 0;
}
private void addToQueue(HashSet<String> wordList, Queue<String> queue, String word){
    wordList.remove(word);
    for (int p = 0; p < word.length(); p++) {
        String prefix = "", suffix="";
        if(p>0) prefix = word.substring(0, p);
        if(p<word.length()) suffix = word.substring(p+1, word.length());
        int letter = word.charAt(p) - 'a';
        for (int k = 0; k < 26 ; k++) {
            if(letter==k) continue;
            String newWord = prefix + ((char)('a' + k)) + suffix;
            if(wordList.contains(newWord)){
                queue.offer(newWord);
                wordList.remove(newWord);
            }
        }
    }
}
}
