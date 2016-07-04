public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord == null || endWord == null || wordList == null || wordList.size() == 0) {
            return 0;
        }
        Queue<String> wordQueue = new LinkedList<String>();
        Queue<Integer> numQueue = new LinkedList<Integer>();
        
        wordQueue.offer(beginWord);
        numQueue.offer(1);
        
        while(!wordQueue.isEmpty()) {
            String word = wordQueue.poll();
            Integer num = numQueue.poll();
            for(int i=0; i<word.length(); i++) {
                char[] arr = word.toCharArray();
                for(char c='a'; c<='z'; c++) {
                    arr[i] = c;
                    String newStr = new String(arr);
                    if(newStr.equals(word)) continue;
                    if(newStr.equals(endWord)) return num + 1;
                    if(wordList.contains(newStr)) {
                        wordQueue.offer(newStr);
                        numQueue.offer(num + 1);
                        wordList.remove(newStr);
                    }
                }
            }
        }
        
        return 0;
    }
}