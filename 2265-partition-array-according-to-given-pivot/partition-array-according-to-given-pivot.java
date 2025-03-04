/*
 Approach - 2 Using two Pointer
 TC. - 0(N) worst case 0(N) + 0(N) if all are pivot
 SC - 0(1)

*/
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int [nums.length];
        int left = 0;
        int right = nums.length - 1;
        
        for( int i = 0, j = nums.length - 1; i < nums.length; i++, j--){
            if(nums[i] < pivot)
                ans[left++] = nums[i];
            
            if(nums[j] > pivot)
                ans[right--] = nums[j];
        }

        //fill in between left & right with pivot
        while(left <= right)
            ans[left++]= pivot;
        
        return ans;
    }
}