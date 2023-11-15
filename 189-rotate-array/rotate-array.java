/* Approach - 1 Reverse Algorithm
TC -  0(n)
SC - 0(1)
*/
class Solution {
    public void rotate(int[] nums, int k) {
        
         k = k % nums.length;
        if(k > nums.length){
          return;
        }
        //Step 1: reverse last N-k elements
        reverseArray(nums, nums.length - k, nums.length - 1);

        //Step 2: reverse first 0 to N - k - 1 element
       reverseArray(nums, 0, nums.length - k - 1);

        //Step 3. reverse entire array 0 to N-1
       reverseArray(nums, 0 , nums.length - 1); 
    }
    //Reverse array
    void reverseArray(int[] nums, int start , int end){
        int left = start ;
        int right = end;
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}