public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        Set<String> map = new HashSet<>(); // record visited words in dict so as not to modify dict
        Queue<String> word = new LinkedList<String>();
        word.add(start);
        
        // BFS
        int depth = 1;
        while (!word.isEmpty()) {
            depth ++; // go to next depth
            int size = word.size();
            for (int j = 0; j < size; j++) {
                String currWord = word.poll();
                
                // change each letter of currWord
                for (int i = 0; i < currWord.length(); i++) {
                    char[] currWordArr = currWord.toCharArray();
                    // try every possible char and check if there's a match in dict
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (currWordArr[i] == c) {
                            continue;
                        }
                        currWordArr[i] = c;
                        String newWord = new String(currWordArr); // for all nodes that neighbor to the currentWord
                        if (newWord.equals(end)) {
                            return depth; // reach the end
                        }
                        if (dict.contains(newWord) && !map.contains(newWord)) {
                            word.add(newWord);
                            map.add(newWord);
                        }
                    }
                }        
            }
            
        }
        
        return 0; // no match is found in dict
    }
}