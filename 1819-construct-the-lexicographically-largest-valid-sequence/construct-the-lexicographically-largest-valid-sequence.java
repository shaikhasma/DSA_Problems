class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] ans = new int[2 * n - 1];
        solve(0, n, ans, new HashSet<Integer>());
        return ans;
    }

    boolean solve(int index, int n , int[] ans, HashSet<Integer> set){
        if(index == ans.length)
            return true;
        
        // if alreday filled then go ahead
        if(ans[index] != 0) 
            return solve(index + 1, n, ans, set);

        for(int number = n; number >= 1; number--){
             //can fill
             if(set.contains(number))
                continue;
                

                if(number == 1){      
                    ans[index]= number;
                    set.add(number);
                    
                    if(solve(index + 1, n, ans, set)) 
                        return true;
                    
                    ans[index] = 0;
                    set.remove(number);
                }
                else if(index + number < ans.length && ans[index + number] == 0){
                    ans[index]= number;
                    ans[index + number] = number;
                    set.add(number);

                    if(solve(index + 1, n, ans, set)){
                        return true;
                    }

                    ans[index]= 0;
                    ans[index + number] = 0;
                    set.remove(number);
                }
        }
        return false;
    }
}