
/*
Time & Space Complexity
✅ Time Complexity: O(D)

The worst-case scenario is when the fraction produces a long recurring decimal, where D is the length of the repeating cycle.
Since every remainder is unique before it repeats, the while loop runs at most D times.
✅ Space Complexity: O(D)

The HashMap stores at most D remainders, making space complexity O(D).
*/
class Solution {
    public String fractionToDecimal(int num, int den) {
        if (num == 0) 
            return "0"; // If numerator is 0, return "0"
        
        StringBuilder ans = new StringBuilder();
        
        // Add sign if the fraction is negative
        if (num < 0 ^ den < 0) ans.append("-");

        // Convert to long to avoid overflow
        long n = Math.abs((long) num);
        long d = Math.abs((long) den);
        
        // Append the integer part of the division to ans
        ans.append(n / d);
        long rem = n % d; 
        
        if (rem == 0) 
            return ans.toString(); // If no remainder, return ansult
        
        ans.append("."); // Add decimal point

        // Map to store remainders and their position in result
        Map<Long, Integer> seen = new HashMap<>();
        
        // Process remainder to get decimal part
        while (rem != 0) {
            if (seen.containsKey(rem)) {
                ans.insert(seen.get(rem), "("); // Insert opening bracket at first occurrence
                ans.append(")"); // Add closing bracket
                break;
            }
            
            seen.put(rem, ans.length()); // Store remainder position
            rem *= 10;
            ans.append(rem / d); // Append quotient
            rem %= d; // Update remainder
        }
        
        return ans.toString();
    }
}
