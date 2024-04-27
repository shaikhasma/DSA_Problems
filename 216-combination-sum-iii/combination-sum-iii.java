class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(k, n, 1,new ArrayList<Integer>(), ans);
        return ans;
    }
    
    void solve(int k, int target, int start, List<Integer> list, List<List<Integer>> ans ){
        if(list.size() == k )
        {
             if(target == 0){
                ans.add(new ArrayList<>(list));
             }
             return;
        }
       
        for (int i = start; i <= 9; i++) {
            list.add(i);
            solve(k, target - i, i + 1, list, ans);
            list.remove(list.size() - 1);         
        }
       
        
    }
}