/*
brute force: find all substrings (n^2), 

pwwkesbwp :  6 kesbwp

这 道题用的方法是在LeetCode中很常用的方法，对于字符串的题目非常有用。 首先brute force的时间复杂度是O(n^3), 对每个substring都看看是不是有重复的字符，找出其中最长的，复杂度非常高。优化一些的思路是稍微动态规划一下，每次定一个起点，然后从起点走到 有重复字符位置，过程用一个HashSet维护当前字符集，认为是constant操作，这样算法要进行两层循环，复杂度是O(n^2)。 
最 后，我们介绍一种线性的算法，也是这类题目最常见的方法。基本思路是维护一个窗口，每次关注窗口中的字符串，在每次判断中，左窗口和右窗口选择其一向前移 动。同样是维护一个HashSet, 正常情况下移动右窗口，如果没有出现重复则继续移动右窗口，如果发现重复字符，则说明当前窗口中的串已经不满足要求，继续移动有窗口不可能得到更好的结 果，此时移动左窗口，直到不再有重复字符为止，中间跳过的这些串中不会有更好的结果，因为他们不是重复就是更短。因为左窗口和右窗口都只向前，所以两个窗 口都对每个元素访问不超过一遍，因此时间复杂度为O(2*n)=O(n),是线性算法。空间复杂度为HashSet的size,也是O(n). 
”


// 窗口类问题，两个前向指针挪动，map 用于 counting sort 中判断字符是否有出现过！ -1 表示未出现，其他表示出现
 O(n)
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        Arrays.fill(map, -1);
        
        int j = 0; // fast pointer
        int i = 0; // slow pointer
        int ans = 0;
        
        for (i = 0; i < s.length(); i++) {
            
            while (j < s.length() && map[s.charAt(j)] == -1) {  // 无重复的时候，把 j 往前挪动,  -1表示未出现过
                map[s.charAt(j++)] = 0; // 把 j 位设置为重复，0表示出现过
                ans = Math.max(ans, j - i);
            }  
            
            map[s.charAt(i)] = -1; // i 位对应的字符, 更新回未出现过
        }
        
        return ans;
    }
}