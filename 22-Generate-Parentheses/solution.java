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
        else if (left == right) {
            addUp(n, left + 1, right, sb.append('('), res);
        }
        else { // add left or right
            int len = sb.length();
            addUp(n, left + 1, right, sb.append('('), res);
            sb.delete(len, sb.length());
            addUp(n, left, right + 1, sb.append(')'), res);
        }
    }
}