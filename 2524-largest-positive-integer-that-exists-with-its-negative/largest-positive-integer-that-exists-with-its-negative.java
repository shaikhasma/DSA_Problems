/* Approach - Sort +  Binary Search


 - Traverse 
   maintain max

 TC- 0(N) + 0(N)
 Sc- (N)
*/
class Solution {
    public int findMaxK(int[] nums) {
       
       HashSet<Integer> set = new HashSet<Integer>();
       int max = Integer.MIN_VALUE;
       int ans = -1;

       for(int index = 0; index < nums.length; index++){
         if(nums[index] < 0)
           set.add(nums[index]);
       }

       for(int index = 0 ; index < nums.length; index++){
    
         if(nums[index] > max &&  nums[index] > 0 && set.contains(-nums[index])){
                ans = nums[index] ;
                max = nums[index];
         }
       }
        
       return ans;
       
    }
}