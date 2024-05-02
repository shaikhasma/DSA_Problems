/* Approach - Sort +  Two pointer appraoch
- Sort array
-- start left = 0 right -= n- 1

-- if sum of left + right elment is zero means both same number with - & + signs
    keep track of max number with right 
    move left++
    move right--

-- if sum < 0 means left is greater and right is smaller with + ve 
  move left++ to match right number

-- sum > 0 
   move right -- to match left number

 [-1,2,-
   - Traverse 
   

 TC- 0(NlogN)
 Sc- 0(1)
*/
class Solution {
    public int findMaxK(int[] nums) {
       
      Arrays.sort(nums);

      int left = 0;
      int right = nums.length - 1;
      int max = Integer.MIN_VALUE;
      
       while(left < right ){
           int sum = nums[left] + nums[right];
            if( sum == 0){
                max = Math.max(max, nums[right]);
                left++;
                right--;
            }
            else if( sum < 0 ){
            left++;
            }
            else{
                right--;
            }
       }
        // if we dont find max then return -1 
       return max != Integer.MIN_VALUE ? max : -1;
       
    }
}