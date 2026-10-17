class Solution {
   public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(arr, 0, new ArrayList<>(), ans, target);
        return ans;
    }

    void solve(int[] arr, int index, List<Integer> list, List<List<Integer>> ans, int target){
        //base
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        if(index >= arr.length) 
            return;
        
        //can take
        if(arr[index] <= target){
            list.add(arr[index]);
            solve(arr, index, list, ans, target - arr[index]);
            list.remove(list.size()-1);
        }
        
        //not take
        solve(arr, index + 1, list, ans, target);

    }
}