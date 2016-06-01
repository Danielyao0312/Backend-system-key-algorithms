public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subres = new ArrayList<>();
        
        if(k > n || k <= 0)   return res;
        dfs(res, subres, n, k, 1);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> subres, int n, int k, int pos) {
        if(subres.size() == k){
            res.add(new ArrayList<Integer>(subres));
            return;
        }
        
        for(int i = pos; i <= n; i++) {
            subres.add(i);
            dfs(res, subres, n, k, i + 1);
            subres.remove(subres.size() - 1);
        }
    }
    
}