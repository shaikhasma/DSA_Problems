class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        solve(1, n, k, new ArrayList<>());
        
        return result;
    }

    void solve(int left , int right,  int k , List<Integer> temp){
      if(k == 0){
         result.add(new ArrayList<>(temp));
         return;
      }

      if(right - left + 1 < k)
         return;

      for(int index = left ; index <= right; index++ ){
        temp.add(index);
        
        solve(index + 1, right, k - 1, temp);

        temp.remove(temp.size() - 1);
      }
    }

}