/*
   Approach - 1 Recursion + Backtraking
   *** Sort Given array first

   pick
   -----
   1. Pick the element when element is less than target
     -- target - picked element
   2. call function recursively with the next element & Note same element to check possiblity of pick again or not
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

Note _ every thing will be same like Combination sum I only difference is 
 - we will pick element only one time and move to next index 
 - To avoid duplicates we can use Set instead of List and at last convert it into List
        OR
    we can avoid i > index && A[i] == A[i-1] skip combination generation

 TC - 0(2 ^ t)* 0(k)
          
      SC - We can not predict space as it completly depedent on number combination
        - 0(K * C) here k is avg lenght of combination & c is number of combination

*/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, 0, target, new ArrayList<Integer>(), ans);
        return ans;
    }
    
    void solve(int[] A, int index, int target, List<Integer> list, List<List<Integer>> ans){
           if (target == 0) {
            ans.add(new ArrayList < > (list));
            return;
        }

        for (int i = index; i < A.length; i++) {
            if (i > index && A[i] == A[i - 1]) 
                continue;

            if (A[i] <= target){
                list.add(A[i]);
                solve(A, i + 1, target - A[i], list, ans);
                list.remove(list.size() - 1);
            }
        }
    }
}