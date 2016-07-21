public class Solution {
    /*
    
    use hashmap to store different groups: 
        key: cda -> acd  sorted str  // find in which group
        value : [cda, cad...] 
    

    return: add all values in hashmap to a arraylist, then return it
    
    
    1. new hashmap and a res
    2. put into the hashmap O(n * maxLen)
            1. when hashmap does not contain this str, add: key: sorted str, value: str itself
            2. when hashmap contains str, add to the key(sorted str)
    3. traverse hashmap, add all values to the res
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        
        if (strs == null || strs.length == 0) {
            return res;
        }
        
        for (String str : strs) {
            String sortedStr = sort(str);
            if (!map.containsKey(sortedStr)) {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(sortedStr, temp);
            } else {
                map.get(sortedStr).add(str);
            }
        }
        
        for (List<String> value : map.values()) {
            res.add(value);
        }
        
        return res;
    }
    
    
    private String sort(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    
}