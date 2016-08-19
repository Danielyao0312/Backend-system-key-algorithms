class TrieNode {
    boolean hasWord; // end of word
    TrieNode[] next;
    
    public TrieNode() {
        hasWord = false;
        next = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root = put(root, word, 0);
    }
    
    private TrieNode put(TrieNode node, String str, int d) {
        if (node == null) {
            node = new TrieNode();
        }
        if (d == str.length()) {
            node.hasWord = true;
            return node;
        }
        int c = str.charAt(d) - 'a';
        node.next[c] = put(node.next[c], str, d + 1);
        return node;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = get(root, word, 0);  // 找到这个单词的最后一个字母节点
        if (node == null) {
            return false;
        }
        return node.hasWord;  // 看看是不是最后的那个字母
    }
    
    private TrieNode get(TrieNode node, String str, int d) {
        if (node == null) {
            return null;
        }
        if (d == str.length()) {
            return node;
        }
        int c = str.charAt(d) - 'a';
        return get(node.next[c], str, d + 1); //往上一层一层地返回最后的那个节点
    }
    

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = get(root, prefix, 0);
        if (node == null) {
            return false;
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");