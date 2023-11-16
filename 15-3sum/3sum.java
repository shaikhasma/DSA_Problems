/* Approach 1 Two Loop + hashing
TC- 0(N^2) + log(no. of unique triplets)
SC- o(N) + O(2 * no. of the unique triplets) 
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      HashSet<List<Integer>> ans = new HashSet<List<Integer>>();
      HashSet<Integer> set = new HashSet<>();

      for(int index = 0; index < nums.length; index++){
       for(int index1 = index + 1; index1 < nums.length; index1++){
           int diff = 0 - nums[index] - nums[index1];
           if(set.contains(diff)){
               ArrayList<Integer> list = new ArrayList<>();
               list.add(nums[index]);
               list.add(nums[index1]);
               list.add(diff);

               Collections.sort(list);
               ans.add(list);
           }
       }
       set.add(nums[index]);
      }
      return new ArrayList<>(ans);
    }
}