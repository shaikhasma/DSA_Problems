/* Approach - Space Optimization 
    -  same logic of max sum of non adjacent element
    - call same function twice 
    1. include 1st element
    2. include last element
TC - 0(N) + 0(N)
SC -  0(N)
*/
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        ArrayList<Integer> temp = new ArrayList<>();
  
        for(int i = 0; i < nums.length - 1 ; i++){
              temp.add(nums[i]);
        }
        
        int includeFirst = maxSum(temp);
        
        temp.remove(0);//exclude 1st
        temp.add(nums[nums.length - 1]);
        int includeLast = maxSum(temp);
        
        return Math.max ( includeFirst, includeLast);
    }

    int maxSum(ArrayList<Integer> nums){
        int prev1 = nums.get(0);
        int prev2 = 0;
        for( int i = 1 ; i < nums.size(); i++){
            int s1 = nums.get(i) +  prev2;
            int s2 = prev1;

            int current = Math.max(s1, s2);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}