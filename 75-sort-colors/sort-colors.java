/*
 Approach - 1 sort 
 TC - 0(logN)
 SC - 0(1)

 Approach - 2 Count 0 & 1 & place it again as per coount
 TC - 0(2N)
 SC - 0(1)

 Appraoch - 3 Two pointer appraoch 
 TC - 0(N)
 SC - (1)

*/
class Solution {
    public void sortColors(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;

        while(mid <= right){
            if(arr[mid] == 0){
               swap(arr, left, mid);
               left++;
               mid++;
            }else if( arr[mid] == 2){
                swap(arr, right, mid);
                right--;
            }else{
                mid++;
            } 
        }
    }
    void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}