class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int mid = 0;
        int right = nums.length-1;

        while(mid <= right){
             if(nums[mid] == 0){
                swap(nums, left, mid);
                left++;
                mid++;
            }else if(nums[mid] == 2){
                swap(nums, right, mid);
                right--;
            }else{
                mid++;
            }    
        }

        for(int index = 0; index < nums.length ; index++){
            System.out.print( nums[index]+ " ");
        }
    }

    void swap(int[] num, int i , int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
       
}