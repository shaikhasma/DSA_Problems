class Solution {
    public boolean isArraySpecial(int[] nums) {
        if(nums.length == 1)    
            return true;

        for(int index = 1; index < nums.length; index++){
            int prev = nums[index - 1];
            int current = nums[index] ;
            //current with previous is same parity or not
            if (current % 2 == prev % 2) {
                return false;
            }   
        }

        return true;
    }
}