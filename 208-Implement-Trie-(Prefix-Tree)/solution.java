/*
using for loop instead of using recursion

更容易理解和记忆！！！
*/

class TrieNode {
    boolean isEnd;
    TrieNode[] next;

    // Initialize your data structure here.
    public TrieNode() {
        isEnd = false;
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
        TrieNode p = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (p.next[index] == null) {   //不存在这个节点，自己造一个，连接到 p, 在把 p 移动到子节点
                TrieNode temp = new TrieNode();
                p.next[index] = temp;
                p = temp;
            } else {  // 存在这个节点！
                p = p.next[index];   // 把 p 指针挪到子节点
            }
        }
        p.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p = searchNode(word);
        return (p != null && p.isEnd);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode p = searchNode(prefix);
        return p != null;   //如果只写一个 return， 就写 什么时候为 true 的那个条件！！！
    }

    private TrieNode searchNode(String str) {
        TrieNode p = root;

        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';

            if (p.next[index] == null) {  //中间如果匹配不上，就找不到
                return null;
            } else {
                p = p.next[index];
            }
        }
        // if (p == root) {
        //     return null;
        // }
        return p;
    }

}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");