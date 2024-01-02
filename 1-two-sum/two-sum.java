class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        int[] ans=new int[2];

        for(int i=0; i<nums.length; i++){
            int secondNo= target - nums[i];
            
            if(map.containsKey(secondNo)){
                ans[0] = i;
                ans[1] = map.get(secondNo);
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}