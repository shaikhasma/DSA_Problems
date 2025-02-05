/*
bank
kanb
*/
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int frSwap = -1;
        int toSwap = -1;
        int count = 0;

        for( int index  = 0; index < s1.length(); index++){
            if(s1.charAt(index) != s2.charAt(index)){
                    count++;
                    if(count > 2)
                        return false;
                  
                   if(frSwap == -1)
                        frSwap = index;
                   else
                        toSwap = index;
                   
            }
        }

        if(count == 0) 
            return true;
        
        return count == 2 && s1.charAt(frSwap) == s2.charAt(toSwap) 
                && s2.charAt(frSwap) == s1.charAt(toSwap);

       
    }
}