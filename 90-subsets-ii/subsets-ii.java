/*
   Approach - Recursion
 [1,2,2]
 - pick up elements from either the first index or the second index or the third index. 
   Pick & Not pick approach
- if we have already picked up two from the 1st index, picking up two from the 2nd index will make another duplicate subset of size one.
   we can avoid picking up from the third index. 

   Intitution - whenever there are duplicate elements in the array we pick up only the first occurrence.

   1. Sort the input array.
   2. Make a recursive function with input array ,the current subset, the current index & a tempList to contain the answer.
   3. consider elements from every index while generating the combinations.
   4. Only pick up elements that are appearing for the first time during a recursion call to avoid duplicates.
   5. Once an element is picked up, move to the next index. 
   6. While returning backtrack by removing the last element that was inserted.

   TC -  O(2^n * k) 
        - 2^n  for generating every subset 
        - k* log( x)  to insert every combination of average length k in a set of size x. 
   
   SC -   O(2^n * k)
        - store every subset of average length k
        - Since we are initially using a set to store the answer another O(2^n *k) is also used.
*/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       List<List<Integer>> ans = new ArrayList<>();

       Arrays.sort(nums);
       solve(nums, 0, new ArrayList<>(), ans);
       return ans;
    }

    void solve(int[] nums, int index, List<Integer> temp, List<List<Integer>> ans){
       ans.add(new ArrayList<>(temp));

       for(int i = index ; i < nums.length; i++){
        
        // if prev equal to current skip it 
        if(i > index && nums[i] == nums[i - 1])
            continue;
         
            //take
            temp.add(nums[i]);
            solve(nums, i + 1, temp, ans);            
            temp.remove(temp.size() - 1);
        
       } 
    }
}