class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return countSubArrayWithSum(nums, k) - countSubArrayWithSum(nums, k - 1) ;
    }
    

    int countSubArrayWithSum(int[] nums, int goal){
        if(goal < 0 )
           return 0;

        int left = 0; 
        int right = 0;
        int count = 0;
        int sum = 0;
         
        while( right < nums.length){
          sum += nums[right] % 2;

          while(sum > goal){
            sum -= nums[left] % 2;
            left++;
          }

        
        count = count + ( right - left + 1); 
        right++;
        }

        return count;
    }
}