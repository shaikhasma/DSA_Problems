class Solution {
    public boolean isArraySpecial(int[] nums) {
        if(nums.length == 1)    
            return true;

        for(int index = 1; index < nums.length; index++){
            int prev = nums[index - 1];
            int current = nums[index] ;
            
            if(!( prev % 2 == 1 && current % 2 == 0) && !( prev % 2 == 0 && current % 2 == 1) )
                return false;       
        }

        return true;
    }
}