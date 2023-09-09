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