/*
   Approach - Recursion

   Pick & Not pick approach

   TC -  O( 2^n *(k log (x) ))
        - 2^n  for generating every subset 
        - k* log( x)  to insert every combination of average length k in a set of size x. 
   
   SC -   O(2^n * k)
        - store every subset of average length k
        - Since we are initially using a set to store the answer another O(2^n *k) is also used.
*/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<ArrayList<Integer>> uniqueSubSets=new LinkedHashSet<>();
        
        solve(nums, 0, new ArrayList<>(), uniqueSubSets);
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.addAll(uniqueSubSets);

        return ans;
    }

    void solve(int[] nums, int index, List<Integer> temp, Set<ArrayList<Integer>> ans){
        if(index == nums.length){
            ans.add(new ArrayList<>(temp));
          return;
        }
        
         // not pick current element
        solve(nums, index + 1, temp, ans);

        //take current element
        temp.add(nums[index]);

        solve(nums, index + 1, temp, ans);

        temp.remove(temp.size() - 1);
       
    }
}