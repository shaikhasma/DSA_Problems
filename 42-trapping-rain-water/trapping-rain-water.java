/*
  Approach - 3 Two pointer approach
  4,2,0,3,2,5

  left = 4
  right = 5

 Idea is ==> we always need 
        -- max from left & max from right
        -- if we have max heigh building on right side means we always get min as left builder 
            so we  can directly use leftMax - currentbuilding height
        -- if we have max heigh building on left side means we always get min as right builder 
            so we  can directly use rigthMax - currentbuilding height
        
    1. we can use left & right pointer which traverse in linear way 
       left from left & right from right
       - We maintain leftMax building & rightMax Buidling

    3. if leftMax < rightMax mean there is greater building on right side 
        so, leftMax - currentbuilding height
       else 
           There is greater building on left side 
           move left
        so, 
           rigthMax - currentbuilding height 
           move right
     4. Take summestion of water trapped 
    5. Repeate till left & right not crossed each other
 
  TC - 0(N)
  SC - 0(1)
*/
class Solution {
    public int trap(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;

        int waterAcc = 0;

        while(left < right){
            leftMax = Math.max(leftMax, arr[left]);
            rightMax = Math.max(rightMax, arr[right]);

            if(leftMax < rightMax){
                waterAcc += leftMax - arr[left];
                left++;
            }else{
                waterAcc +=  rightMax - arr[right];
                right--;
            }
        }

        return waterAcc;
    }
}