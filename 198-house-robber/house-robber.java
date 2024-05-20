/*.    Approach 3 - Space Optimazation

 TC - 0(N)
 SC - 0(1)
    
*/
class Solution {
    public int rob(int[] nums) {
 
     int prev1 = nums[0];
     int prev2 = 0;

     for(int index = 1; index < nums.length; index++){
        int pick = nums[ index ]; 
        
        if(index > 1)
           pick +=  prev2;

        int notPick = prev1;
    
        int current = Math.max(pick, notPick);
        // move prev2 prev1
        prev2 = prev1;
        prev1 = current;
     }

     return prev1;
    }
}