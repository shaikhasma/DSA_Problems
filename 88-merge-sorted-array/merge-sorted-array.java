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
    public void merge(int[] nums1, int n, int[] nums2, int m) {
        int i = n - 1;  // Last element in nums1's actual data
        int j = m - 1;  // Last element in nums2
        int k = n + m - 1;  // Last position in nums1

        // Merge in reverse order
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If there are elements left in nums2, copy them
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
