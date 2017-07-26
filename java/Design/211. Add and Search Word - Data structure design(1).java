class TrieNode {
    public char c;
    public boolean isWord = false;
    public TrieNode[] children;

    TrieNode(char c) {
        this.c = c;
        children = new TrieNode[26];
    }
}


public class WordDictionary {

    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode(' ');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode iter = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (iter.children[c - 'a'] == null) {
                iter.children[c - 'a'] = new TrieNode(c);
            }
            iter = iter.children[c - 'a'];
        }
        iter.isWord = true;

    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(word, 0, root);
    }

    public boolean helper(String word, int index, TrieNode node) {
        if (index == word.length()) return node.isWord;

        char c = word.charAt(index);

        if (c != '.') {
            if (node.children[c - 'a'] == null) return false;
            else return helper(word, index + 1, node.children[c - 'a']);
        }
        else {
            for (TrieNode n: node.children) {
                if (n == null) continue;
                if (helper(word, index + 1, n)) return true;
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
