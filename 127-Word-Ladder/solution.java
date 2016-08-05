public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        Set<String> set = new HashSet<>(); // record visited words in dict so as not to modify dict
        Queue<String> q = new LinkedList<String>();
        q.add(start);
        set.add(start);
        
        // BFS
        int depth = 1;
        while (!q.isEmpty()) {
            depth ++; // go to next depth
            int size = q.size();
            for (int j = 0; j < size; j++) {
                String currWord = q.poll();
                
                // for all nodes that neighbor to the currentWord
                // change each letter of currWord
                for (int i = 0; i < currWord.length(); i++) {
                    char[] currWordArr = currWord.toCharArray();
                    // try every possible char and check if there's a match in dict
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (currWordArr[i] == c) {
                            continue;
                        }
                        currWordArr[i] = c;
                        String newWord = new String(currWordArr);  // newWord is the neighbor to currentWord
                        if (newWord.equals(end)) {
                            return depth; // reach the end
                        }
                        
                        if (dict.contains(newWord) && !set.contains(newWord)) {
                            q.add(newWord);
                            set.add(newWord);
                        }
                    }
                }        
            }
            
        }
        
        return 0; // no match is found in dict
    }
}