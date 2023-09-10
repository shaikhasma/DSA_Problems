/* Approach 2 - Compare & swap
1. compare nums1 every elements with nums2 first element
2. if nums1[i] > nums2[0] then swap it
3. take 1st element of nums2
3. All smaller elements move to left side in nums2 by one place 
   do it for all the elements from 1 to N - 1
4. keep first element at last

TC- 0(NM)
SC- 0(1)
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
     if(nums1.length == 0 || nums2.length == 0)
        return;

     for(int index = 0; index < m; index++){
        if(nums1[index] > nums2[0]){
            swap(nums1, index, nums2, 0);
        }

        int first = nums2[0];
        int j = 1;
        for(; j < nums2.length && nums2[j] < first ; j++)
            nums2[j - 1] = nums2[j];
        
        nums2[j - 1] = first;
     }
      
        int pos = m;
        for(int index = 0 ; index < n; index++)
            nums1[pos++] = nums2[index];

    }

    void swap(int[] A, int index1, int[] B, int index2){
        int temp = A[index1];
        A[index1] = B[index2];
        B[index2] = temp;
    }
}
