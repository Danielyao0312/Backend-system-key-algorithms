/*
word => sort => as key
hashmap:  key : aet (sorted string), value :[ate, eat, tea] => arraylist

1. put into hashmap
2. put all values into the result
*/

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        
        if (strs == null || strs.length == 0) {
            return res;
        }
        
        for (String str : strs) {
            String sorted = sort(str);
            
            if (!map.containsKey(sorted)) {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(sorted, temp);
            } else {
                map.get(sorted).add(str);
            }
        }
        
        for (List<String> sub : map.values()) {
            res.add(sub);
        }
        return res;
    }
    
    private String sort(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}