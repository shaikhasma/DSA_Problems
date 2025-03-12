/* Approach 1 : linear traversal
TC - 0(N)
TC - 0(1)

Approach 2 - Binary Search
1. find 1st positive number
2. find last negative number
    
negCount = lastNeg + 1;
posCount = length - 1 - firstPos;
return Math.max(negCount, postCount)
TC - 0(logN) + 0(logN)
SC - 0(1)

*/
class Solution {
    public int maximumCount(int[] nums) {
        //if 1st is negative all are negative
        if (nums[0] > 0) 
            return nums.length;
            // If the last element is negative, all elements are negative
        if (nums[nums.length - 1] < 0) 
            return nums.length;

        int firstPositive = findFirstPositive(nums);
        int lastNegative = findLastNegative(nums); 
        int posCount = 0;
        int negCount = 0;

        if(firstPositive != -1) 
         posCount = nums.length - firstPositive ;

        if(lastNegative != -1)
         negCount = lastNegative + 1;

        return Math.max(posCount, negCount);
    }

    int findFirstPositive(int[] nums){
        int low = 0; 
        int high = nums.length - 1;
        int ans = -1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(0 < nums[mid] ){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    int findLastNegative(int[] nums){
        int low = 0; 
        int high = nums.length - 1;
        int ans = -1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(0 > nums[mid] ){
               ans = mid;
               low = mid + 1;
            }else{
                 high = mid - 1;
            }
        }

        return ans;
    }
}
