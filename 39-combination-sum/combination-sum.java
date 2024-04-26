/*
   Approach - 1 Recursion + Backtraking
   pick
   -----
   1. Pick the element when element is less than target
     -- target - picked element
   2. call function recursively with the same element to check possiblity of pick again or not
   3. here if we come back from recurive call 
      -- remove current element as next step we are going to exclude or not pick current element 
   
   Not pick
   ---------
   4. if we cant pick we take other option not to pick element 
     -- call function recursively with the next element without updating target as we are not picking current element


   Base Case 
   1. - While performing any option if we find target before reaching to last index 
      - fill temp list of comibination into ans & return back 
   
   2. If we reach to last index & unfortunetly we dont found target 
      - simply return back

      TC - 0(2^t)* k 
          -  where t is target as we can pick same element multiple time we can pick 1 10 time if target is 10
          - k is avg length of every generated compination which we fill to ans list which will take linear time not constant

      SC - We can not predict space as it completly depedent on number combination
        - 0(K * C) here k is avg lenght of combination & c is number of combination
*/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        solve(candidates, 0,target, new ArrayList<Integer>(), ans);
        return ans;
    }
    
    void solve(int[] A, int index, int target, List<Integer> list, List<List<Integer>> ans){
        //if before reaching to end target sum found
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        // we reach to last if in case we find target fill to ans list & go back 
        //else directly return back 
        if (index == A.length ){
             //if(target == 0) {
              //  ans.add(new ArrayList < > (list));  
             //}  
            return;
        }
         //include
        if (A[index] <= target) {
            list.add(A[index]);

            solve(A,index, target - A[index], list, ans);
           
            list.remove(list.size() - 1);
        }
        //exclude
        solve(A, index + 1, target, list, ans);
    }
}