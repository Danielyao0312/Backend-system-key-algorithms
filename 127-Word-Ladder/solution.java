/*
find shortest length of transformation => find the shortest path in word graph => use BFS

corner cases:
1. endWord not exist
2. beginword == endword

hot => dog
*/

public class Solution {

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }

        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(beginWord);
        set.add(beginWord);

        int depth = 1; //出错点！初始 depth 为1， 因为已经有一个点在 q 中(为第一层)
        while (!q.isEmpty()) {
            depth ++;  // 进入下一层
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                for (String nextWord : getNextWords(cur, wordList)) { // for all nodes neighbor to cur
                    if (!set.contains(nextWord)) {
                        if (nextWord.equals(endWord)) {   // 如果 bfs 找到了，那就返回长度
                            return depth;  
                        }
                        set.add(nextWord);
                        q.add(nextWord);
                    }
                }
            }
        }
        return 0;  //没找到,返回0
    }

    /*
    *  abcd => 每一位有26种变化,一共有4位, 总共有26*4种变化, 看这些变换, 哪些在wordlist 即可
    */
    private ArrayList<String> getNextWords(String str, Set<String> wordList) {
        ArrayList<String> res = new ArrayList<>();
        
        for (int i = 0; i < str.length(); i++) {  // for 每一位
            for (char c = 'a'; c <= 'z'; c++) { // 有26种变化
                if (c == str.charAt(i)) {
                    continue;
                }
                char[] arr = str.toCharArray();
                arr[i] = c;
                String replacedStr = new String(arr);

                if (wordList.contains(replacedStr)) {
                    res.add(replacedStr);
                }
            }
        }
        return res;
    }
}
