/* Approach - 2 Sort + Binary Search + recursion backtracking
TC - 0( n log n)+ 0(log N) + 0(2^n)
SC - 0(N)stack + 0(N) temp string
*/
 
class Solution {
    int n;
    String ans = "";
   
    public String findDifferentBinaryString(String[] nums) {
     Arrays.sort(nums);     
     n = nums.length;  
     solve(nums, 0, "" );
     return ans;

    }

    boolean solve(String[] nums, int index, String temp){
        if(index == n){
            if (Arrays.binarySearch(nums, temp) < 0) { // Not found
                ans = temp;
                return true;
            }
            return false;
        }
        
        for( char ch : new char[]{'0','1'}){
            if(solve(nums, index + 1, temp + ch)) 
                return true;
        }

        return false;  
    }
}