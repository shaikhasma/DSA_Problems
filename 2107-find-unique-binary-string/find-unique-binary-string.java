class Solution {
    HashSet<String> hash = new HashSet<>();
    int n;
    String ans = "";
   
    public String findDifferentBinaryString(String[] nums) {
     for(String str : nums){
        hash.add(str);
     }      
     n = nums[0].length();  
     solve(0, "" );
     return ans;

    }

    boolean solve(int index, String temp){
        if(index == n){
            if(!hash.contains(temp)){
                ans = temp;
                return true;
            }
            return false;
        }
        
        for( char ch : new char[]{'0','1'}){
            if(solve(index + 1, temp + ch)) 
                return true;
        }

        return false;  
    }
}