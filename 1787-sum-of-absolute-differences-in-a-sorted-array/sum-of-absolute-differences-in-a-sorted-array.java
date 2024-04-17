class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] prefix = new int[nums.length];
        
        prefix[0] = nums[0];
        int[] ans = new int[nums.length];
        for(int index = 1; index < nums.length; index++ ){
            prefix[index] = prefix[index - 1] + nums[index];
        }

        int[] suffix = new int[nums.length];
        suffix[nums.length - 1] = nums[nums.length - 1];

        for(int index = nums.length - 2; index >= 0; index--){
            suffix[index] = suffix[index + 1] + nums[index];
        }

        for(int index = 0; index < nums.length; index ++){
            int leftLen = index - 0 + 1;
            int rightLen = nums.length - index;
        
            ans[index] +=  (leftLen * nums[index]) - prefix[index];
            ans[index] +=  suffix[index] - (rightLen * nums[index]);
        
        }

        return ans;

    }


}