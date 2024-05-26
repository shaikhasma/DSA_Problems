class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();

        solve(candidates, 0, target, new ArrayList<Integer>() , list);

        return list;
    }

    void solve(int[] arr, int index , int target, ArrayList<Integer> temp, List<List<Integer>> list){
      
      if(target == 0){
        list.add(new ArrayList<>(temp));
        return;
      }
         
      for(int i = index ; i < arr.length; i++){
        if(arr[i] <= target){
          temp.add(arr[i]);
          
          solve(arr, i, target - arr[i], temp, list);
          
          temp.remove(temp.size() - 1);
        }
      }
    }
}