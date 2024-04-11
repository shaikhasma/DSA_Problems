/* Approach - 1 Brute force
 -- merged two sorted array 0(max(arr1, arr2))
 -- if size of merged array is odd 
      return size / 2
    else 
       size / 2 - (size / 2 ) - 1 two median values need to take from them
       so 
          return (size / 2 - (size / 2 ) - 1 ) / 2
    TC - 0(max(arr1, arr2))
    SC - 0(1)
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray  = mergeSortedArray(nums1, nums2);
        int n = nums1.length + nums2.length;
        if(n % 2 == 1)
          return (double) mergedArray[ n / 2];

        return ( (double)(mergedArray[n / 2])+ 
                 (double) (mergedArray[(n / 2) - 1]) ) / 2.0;
    
    }

    int[] mergeSortedArray(int[] nums1, int[] nums2){
        int[] mergedArray = new int[nums1.length + nums2.length];

        int pointer1 = 0;
        int pointer2 = 0;
        int pos = 0;
        while(pointer1 < nums1.length && pointer2 != nums2.length){
            
            if(nums1[pointer1] < nums2[pointer2]){
                mergedArray[pos++] = nums1[pointer1++];
            }else{
                mergedArray[pos++] = nums2[pointer2++];
            }

        }

        while(pointer1 < nums1.length)
           mergedArray[pos++] = nums1[pointer1++];
    
        while(pointer2 < nums2.length)
           mergedArray[pos++] = nums2[pointer2++];

        return mergedArray;
    }
}