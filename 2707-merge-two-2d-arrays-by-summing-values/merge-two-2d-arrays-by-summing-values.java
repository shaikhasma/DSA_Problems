/*
 [1 2].   [1 4]
 [2 3].   [3 2]
 [4 5].   [4 1]
 1 - 2 + 4
 2 - 3
 3 - 2
 4- 5 + 1
 Approach 1 - Using TreeMap
  k unique Ids
  N array one size 
  M array two size
 TC - 0(N log K) + 0( M log K) + 0(K)
        add nums1     add nums2.  map traversal
    - 0( N + M log K)
 SC - 0(k) = 0(N+M)  

 TreeMap<Integer, Integer> map = new TreeMap<>();

        trackArray(nums1, map);
        trackArray(nums2, map);
        
        
        int[][] ans = new int[map.size()][2];

        int row = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) { 
            int id = entry.getKey();
            int val = entry.getValue();

            ans[row][0] = id;
            ans[row][1] = val;

            row++;
        }

        return ans;
    }

    void trackArray(int[][] arr, TreeMap<Integer, Integer> map){
        for( int index = 0 ; index < arr.length; index++)  {
            int id = arr[index][0];
            int val = arr[index][1];

            map.put(id, map.getOrDefault(id,0) + val); 
        }
    }
---------------------------------------------------------------------------------
Approach - Two Pointer 
TC - 0(N) + 0(M)
SC - 0(N + M)

*/
class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int left = 0 ;
        int right = 0;
        List<int[]> ans = new ArrayList<>();

        while(left < nums1.length && right < nums2.length){
            if (nums1[left][0] < nums2[right][0]){
                ans.add(new int[] {
                        nums1[left][0], nums1[left][1]
                });

                left++;
            }else if(nums1[left][0] == nums2[right][0]){
                ans.add(new int[] {
                        nums2[right][0], 
                        nums1[left][1] + nums2[right][1]
                });

                left++;
                right++;
            }else{
                ans.add(new int[] {
                        nums2[right][0], nums2[right][1]
                });

                right++;
            }
        }

        // if nums1 pair remaining
        while(left < nums1.length){
            ans.add(new int[] {
                        nums1[left][0], nums1[left][1]
                });

            left++;
        }

        // if nums2 pair remaining
        while(right < nums2.length){
            ans.add(new int[] {
                            nums2[right][0], nums2[right][1]
                    });

            right++;
        }
        //convert List<int[]> to int[][]
        int[][] result = new int[ans.size()][2];
        for (int index = 0; index < ans.size(); index++) 
            result[index] = ans.get(index);

        return result;
    }
}