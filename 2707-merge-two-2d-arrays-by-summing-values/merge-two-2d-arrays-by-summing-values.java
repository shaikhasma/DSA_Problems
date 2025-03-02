/*
 [1 2].   [1 4]
 [2 3].   [3 2]
 [4 5].   [4 1]
 0 1 2 3 4 5 6 
 []


*/
class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
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
}