public class Solution {

    public List<Integer> majorityElement(int[] nums) {
    List<Integer> list = new ArrayList<>();
    int n = nums.length;
    if (n == 0) return list;
    
    int num1 = 0, num2 = 0; 
    int count1 = 0, count2 = 0;
    for (int i = 0; i < n; i++) {
        int val = nums[i];
            if (num1 == val) {
                count1 ++;
            } else if (num2 == val) {
                count2 ++;
            } else if (count1 == 0) {
                num1 = val;
                count1 = 1;
            } else if (count2 == 0) {
                num2 = val;
                count2 = 1;
            } else {
                count1 --;
                count2 --;
            }
    }
    
    if (isOneThirdMajority(num1, nums)) list.add(num1);
    if (num1 != num2 && isOneThirdMajority(num2, nums)) list.add(num2);
    return list;
}

private boolean isOneThirdMajority(int val, int[] nums) {
    int n = nums.length;
    int count = 0;
    for (int i = 0; i < n; i++)
        if (nums[i] == val) count++;
    if (count > n / 3)  return true;
    else                return false;
}
    
}