/* app - brute force : TLE
 for each index check all posible contain & 
 compare , saved max area of container
 TC - 0(N^2)
 SC - 0(1)

 public int maxArea(int[] height) {
        int maxWater = Integer.MIN_VALUE;
        for(int index = 0; index < height.length; index++){
            for(int j = index + 1; j < height.length; j++){
                int width = j - index;
                maxWater = Math.max(maxWater, width * Math.min(height[index], height[j]));
            }
        }
        return maxWater;
    }

Approach - 2 Two pointer approach + greedy
left = 0
right = lenght - 1
which calculate area first compare max container water and save it

Greedy App
if left < right then we need to move left ahead 
right is still max so we can store max water only need 
else 
   vice versa

TC - 0(N)
SC - 0(1)
 
*/
class Solution {
    public int maxArea(int[] height) {
        int maxWater = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            int width = right - left ;
            maxWater = Math.max(maxWater, width * Math.min(height[left], height[right]));

            if(height[left] < height[right])
               left++;
            else
               right--;
        }
        return maxWater;
    }
}