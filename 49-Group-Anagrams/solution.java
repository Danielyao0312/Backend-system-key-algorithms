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
            String sorted = labelStr(str);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<String>());
            } 
            map.get(sorted).add(str);
        }
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }
    
    // apple => a1e1l1p2 : O(n)    
    private String labelStr(String str) {
        int[] count = new int[256];
        for (int i = 0; i < str.length(); i++) {
            // counting sort :
            // 下标对应字符的 ascii 码，value 对应的是字符个数！
            count[str.charAt(i)]++; 
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 256; i++) {
            if (count[i] > 0){
                sb.append((char)i).append(count[i]);
            }
        }
        return sb.toString();
    }
    
    
    //sort: apple => aelpp:  O(nlogn)
    private String sort(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}