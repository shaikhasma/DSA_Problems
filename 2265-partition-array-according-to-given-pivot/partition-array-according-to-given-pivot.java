/*
 Approach - 1 using temp1 & temp2 array for less and greater elements
 TC. - 0(N)
 SC - 0(N)
*/
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();
        
        for(int index = 0; index < nums.length; index++){
            if(nums[index] < pivot)
                temp1.add(nums[index]);
            else if(nums[index] > pivot)
                temp2.add(nums[index]);
        }

        int totPivot = nums.length - ( temp1.size() + temp2.size() );
        for( int index = 0; index < temp1.size(); index++)
            nums[index] = temp1.get(index);

        for( int index = temp1.size(); index < (temp1.size() + totPivot); index++)
            nums[index] = pivot;

        int idx = (temp1.size() + totPivot);
        for( int index = 0 ; index < temp2.size(); index++)
            nums[idx++] = temp2.get(index);


        return nums;
    }
}