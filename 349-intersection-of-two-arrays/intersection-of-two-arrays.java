/* Approach - Hashing
1. Traverse & Add all elements of array 1 into HashSet
2. Traverse all element of array 2 
-  check if array2[index] is already contains in set
-  If yes then it's intersection add into result array
-  remove from set so it wont cansider again for result array
TC - 0(n+ nlogn + m)
Sc - 0(n)
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int index = 0; index < nums1.length; index++){
            set.add(nums1[index]);
        }

        
        for(int index = 0; index < nums2.length; index++){
            if(set.contains(nums2[index])){
                 list.add(nums2[index]); 
                 set.remove(nums2[index]);
            }
        }
         return list.stream().mapToInt(i -> i).toArray();
    }
}