/** 
Problem : Two Sum 
Approach : Using Hashing
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] sumIndex = new int[2];
        for(int index = 0; index < nums.length; index++){
            int difference = target - nums[index];
            if(map.containsKey(difference)){
                sumIndex[0] = map.get(difference);
                sumIndex[1] = index;
                return sumIndex;
            }else{
                map.put(nums[index], index);
            }
        }

        return sumIndex;
    }
}
/**
TC : 0(N)
SC : 0(N)
 */
