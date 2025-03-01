/*
Approach - 1 Traverse two time + Two pointer
0 1 2 3 4 5
1,4,0,2,0,0
    l
    r
 
[1694,399,832,0,0,0,0,0,1758,0,412,0,206,272]
              l
                          r
TC - 0(N)+0(N)
SC - 0(1)
*/
class Solution {
    public int[] applyOperations(int[] nums) {
        for(int index = 0; index < nums.length - 1; index++){
            if(nums[index] == nums[index + 1]){
                nums[index] *= 2;
                nums[index + 1] = 0;
            }
        }
    
        int left = 0;
        int right = 0;
        // shift all non -zero number to left with maintaining relative order
        while(right < nums.length){
            if(nums[right] > 0){
                nums[left] = nums[right];
                left++;
            }
       
            right++;
        }
        // Fill remaining position with zero
        while(left < nums.length){
            nums[left] = 0;
            left++;
        }

        return nums;
        
    }
}