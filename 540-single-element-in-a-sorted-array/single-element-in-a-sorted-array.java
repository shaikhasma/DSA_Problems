/*  
Approach 1 - Binary Search
 1,1,2,3,3,4,4,8,8
 0 1 2 3 4 5 6 7 8
 l       M       h  
 8/2 = 4

 3,3,7,7,10,11,11
 0 1 2 3  4  5   6 
 6/2 = 3
 10/ 2 = 5

 8/2 

 TC - o(logn)
 SC - 0(1)



 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
         if(nums.length==1) return nums[0];
        int l = 0;
        int h = nums.length-1;
        
        while(l<h){
            int mid = l + (h-l)/2;      // divide the array
            
            if(nums[mid] == nums[mid+1]) mid = mid-1;      //two same elements should be in same half
            
            if((mid - l + 1) % 2 !=0) h = mid;            // checking the length of left half. If its is odd then update ur right pointer to mid
            
            else l = mid+1;    // else your right half will be odd then update your left pointer to mid+1
        }
        
        return nums[l];
    }
}