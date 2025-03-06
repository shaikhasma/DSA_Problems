
/*
Time & Space Complexity
✅ Time Complexity: O(D)

The worst-case scenario is when the fraction produces a long recurring decimal, where D is the length of the repeating cycle.
Since every remainder is unique before it repeats, the while loop runs at most D times.
✅ Space Complexity: O(D)

The HashMap stores at most D remainders, making space complexity O(D).
*/
class Solution {
    public String fractionToDecimal(int num, int deno) {
          if (num == 0) 
              return "0";
        StringBuilder ans = new StringBuilder();

       // if n or d is -ve attach - sign
        if((num < 0 && deno >= 0 ) || ( num >= 0 && deno < 0))
            ans.append("-");

        // remove -ve sign , avoid overflow
        long n = Math.abs((long) num);
        long d = Math.abs((long) deno);

        // if full division
        ans.append(n/d);
        long rem = n % d;
        if(rem == 0)
            return ans.toString();
        
        //if fractional division
        Map<Long, Integer> map = new HashMap<>();
        ans.append(".");

        while(rem != 0){
            if(map.containsKey(rem)){
                int index = map.get(rem);
                ans.insert(index, "(");
                ans.append(")");
                break;
            }
            map.put(rem, ans.length());

            //division
            rem = rem * 10; // attach 0
          
            ans.append(rem / d);
            rem = rem % d;
        }

        return ans.toString();
    }
}
