/*
   Approach - 1 Recursion + Backtraking
   Start with 0 index (index )

   1 Traverse i from index to last index

   2. Pick the element when element is less than target
    -- target - picked element or reduce target by picked element

   3. call function recursively with the same element to check possiblity of pick again or not

   4. here if we come back from recurive call 
    -- remove current element as next step we are going to exclude or not pick current element 

  Repeate all 2 3 4 steps till i <= last index 


   Base Case 
   1. - While performing any option if we find target before reaching to last index 
      - fill temp list of comibination into ans & return back 

      TC - 0(2^t) * k 
          -  where t is target as we can pick same element multiple time we can pick 1 10 time if target is 10
          - k is avg length of every generated compination which we fill to ans list which will take linear time not constant

      SC - We can not predict space as it completly depedent on number combination
        - 0(K * C) here k is avg lenght of combination & c is number of combination
*/
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