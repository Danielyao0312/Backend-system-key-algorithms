public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        Set<String> map = new HashSet<>(); // record visited words in dict so as not to modify dict
        Queue<String> word = new LinkedList<String>();
        Queue<Integer> depth = new LinkedList<Integer>();
        word.add(start);
        depth.add(1);
        
        // BFS
        while (!word.isEmpty()) {
            String currWord = word.poll();
            int currDepth = depth.poll();
            // return depth if a match is found
            if (currWord.equals(end))    return currDepth;
            // change each letter of currWord
            for (int i = 0; i < currWord.length(); i++) {
                char[] currWordArr = currWord.toCharArray();
                // try every possible char and check if there's a match in dict
                for (char c = 'a'; c <= 'z'; c++) {
                    if (currWordArr[i] == c) {
                        continue;
                    }
                    currWordArr[i] = c;
                    String newWord = new String(currWordArr);
                    if (dict.contains(newWord) && !map.contains(newWord)) {
                        word.add(newWord);
                        depth.add(currDepth + 1);
                        map.add(newWord);
                    }
                }
            }
        }
        
        return 0; // no match is found in dict
    }
}