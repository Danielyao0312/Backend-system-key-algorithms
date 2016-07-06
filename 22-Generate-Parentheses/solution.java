/*
Backtracking

suppose the number of left brackets = left, num of right brackets = right;
three cases:
1. if left = n  => only add right bracket until right == n;
2. if left = right < n => only add left bracket
3. otherwise: add left bracket or right bracket;

 */

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        addUp(n, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void addUp(int n, int left, int right, StringBuilder sb, List<String> res) {
        if (left == n) {
            while (right < n) {
                sb.append(')');
                right ++;
            }
            res.add(sb.toString());
        } 
        else if (left == right && left < n) {
            sb.append('(');
            addUp(n, left + 1, right, sb, res);
        } 
        else { // add left or right
            int len = sb.length();
            sb.append('(');
            addUp(n, left + 1, right, sb, res);
            sb.delete(len, sb.length());

            sb.append(')');
            addUp(n, left, right + 1, sb, res);

        }
    }
}