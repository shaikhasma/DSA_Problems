/** Striver SDE Sheet Challenge By Asma 
Problem : Two Sum 
Approach : Using Hashing
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
         int[] ans = new int[2];
        for(int index = 0; index < nums.length; index++){
            int secondPart = target - nums[index];
          
            if(map.containsKey(secondPart)){
                ans[0] = index;
                ans[1] = map.get(secondPart);
                return ans;
            }
            
            map.put(nums[index], index);
        }
        return ans;
    }
}
/**
TC : 0(N)
SC : 0(N)
 */