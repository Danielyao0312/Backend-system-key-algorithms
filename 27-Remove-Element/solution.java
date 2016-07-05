

public class Solution {
    public int removeElement(int[] arr, int val) {
        if (arr.length == 0) {
            return 0;
        }

        int m = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                arr[m] = arr[i];
                m++;
            }
        }
        return m;
    }
}
