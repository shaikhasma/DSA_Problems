/* Asma shaikh
Approach - Moore's Algo
TC- 0(2n) = > 0(n)
SC - 0(1)
*/
class Solution {
    public int majorityElement(int[] nums) {
     int number = 0;
     int count = 0;

     for(int index = 0 ; index < nums.length; index++){
         if(count == 0){
             number = nums[index];
             count = 1;
         }else if(nums[index] == number){
             count++;
         }else{
             count--;
         }
     }

     //verify
     count = 0;
     for(int index = 0; index < nums.length; index++){
         if(number == nums[index])
           count++;
     }

     if(count > nums.length / 2){
         return number;
     }
     
     return -1;
  }
}