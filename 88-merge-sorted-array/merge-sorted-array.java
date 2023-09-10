/* Approach 1 - Brute force
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
     for(int index = 0; index < m  ; index++)
         nums1[index] = ans[pos++];

     for(int index = 0 ; index < n; index++){
        nums1[pos] = ans[pos++];
     }

     
    }
}
