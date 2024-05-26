
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
       // Arrays.sort(candidates);
        solve(candidates, 0, target, new ArrayList<Integer>(), list);
       return list;
    }
    
    void solve(int[] A, int index, int target, List<Integer> list, List<List<Integer>> ans){
     if(target == 0){
        ans.add(new ArrayList<>(list));
        return;
     }

     for(int i = index; i < A.length; i++){
        if(target >= A[i]){
            list.add(A[i]);
            solve(A, i, target - A[i], list, ans);

            list.remove(list.size() - 1);
        }
     }    
    }
}