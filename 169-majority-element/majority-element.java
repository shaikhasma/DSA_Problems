class Solution {
    public int majorityElement(int[] nums) {
       HashMap<Integer,Integer> map = new HashMap<>();

       for(int index = 0; index < nums.length; index++){
           int count = map.getOrDefault(nums[index], 0);
           map.put(nums[index], count + 1);
       }

       for(Map.Entry<Integer, Integer> entry : map.entrySet()){
          if(entry.getValue() > (nums.length / 2)){
              return entry.getKey();
          }
       }

       return -1;
    } 
}