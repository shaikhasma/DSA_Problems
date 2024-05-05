/* Approach - Recursion + Backtracking
TC: O(2^n)
SC: 0(N) temp list
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //if(nums==null || nums.length==0)   
        //   return list;
         
        subsets(nums, list, new ArrayList<Integer>(), 0); 
        
        return list;
    }

    private void subsets(int[] nums,  List<List<Integer>> list , ArrayList<Integer> temp, int index) {
        // base condition
        if(index == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        
        // main logic

        // case 2 : we don't pick the element ( notice,
        // we did not add the current element in our temporary list
        subsets(nums, list, temp, index+1); // move ahead


		// case 1 : we pick the element
        temp.add(nums[index]);
        subsets(nums, list, temp, index + 1); // move ahead
        temp.remove(temp.size() - 1);
        
		

    }
}