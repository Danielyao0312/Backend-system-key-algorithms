/*
1. group them the strings => 
hashmap:
key : sorted string : aet
values: string itself : ate, eat, tea....

2. traverse the hashmap, put values into res

*/

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
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
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }
    
    
    private String sort(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}