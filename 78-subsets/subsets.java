/* Approach - Recursion + Backtracking
TC: O(n * 2^n)
SC: O(n * 2^n)
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> ans = new ArrayList<>();

       solve(nums, 0, ans, new ArrayList<>());
       return ans;
    }

    private void solve(int[] nums, int index,  List<List<Integer>> result , ArrayList<Integer> temp) {
        if(index >= nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        //take 
        temp.add(nums[index]);
        solve(nums, index + 1, result, temp );
        
        //backtrack
        //not pick
        temp.remove(temp.size() - 1);
        solve(nums, index + 1, result, temp);
    }
}