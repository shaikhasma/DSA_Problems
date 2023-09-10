/* Approach 1 - Brute force
1. Create new array n + m size
2. take all num1 & num2 elements
3. Sort new array
4. Keep all element in 
TC- 0(nlogn + n + m)
  - 0( N  + M)
SC- 0(n+m)
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
     int[] ans = new int[n + m];
     
     int pos = 0;
     for(int index = 0; index < m ; index++)
         ans[pos++] = nums1[index];

     for(int index = 0 ; index < n ; index++)
         ans[pos++] = nums2[index];

     Arrays.sort(ans);

     pos = 0;
     for(int index = 0; index < m + n  ; index++)
         nums1[index] = ans[pos++];   
    }
}
