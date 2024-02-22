/* Approach - find break point + find closed greater of break point swap + sort remaining
TC - 0(n) find break point
     0(n) find closest greater
     0(n) reverse array
     0(3N)
     ~ 0(N)

SC - 0(1)
 1 2 3
 0 1 2
 breakPoint = 1
 nerestGreaterClosed of breakPoint = 2 index i.e 3

 reverse from 1 to 2
 1 3 2


 3 2 1
 0 1 2

 no break Point reveres 
1 2 3

*/

class Solution {
    public void nextPermutation(int[] nums) {
        int breakPoint = -1;
       //Step 1 - find the break point
        for(int index = nums.length - 2; index >=0; index--){
            if(nums[index] < nums[index + 1]){
                breakPoint = index;
                break;
            }
        }

        //Step 2 - if dont have any break point
        if(breakPoint == -1){
            reverse(nums, 0, nums.length - 1);
            return;
        }

        //Step 3 - find the closet next greater then breakPoint & swap
        for(int index = nums.length - 1; index >= 0; index--){
            if(nums[breakPoint] < nums[index]){
                swap(nums, breakPoint, index);
                break;
            }
        }

        //step 4 - Sort the remaining elements( breakPoint + 1 to end)
        reverse(nums, breakPoint + 1, nums.length -1 );
    }
    
    void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
    void reverse(int[] A, int i, int j){
        while(i < j){
            swap(A, i, j);
            i++;
            j--;
        }
    }
}