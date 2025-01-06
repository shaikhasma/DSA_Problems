/*
TC :
Building shiftDelta: \U0001d442(\U0001d45a), where \U0001d45a is the number of shifts.
Prefix sum computation: \U0001d442(\U0001d45b)
O(n), where \U0001d45b is the string length.
Applying shifts: \U0001d442(\U0001d45b)O(n).
Total: \U0001d442(\U0001d45a+\U0001d45b)

SC:
O(n) for shiftDelta and netShifts.
O(n) for character array chars.
Total: \U0001d442(\U0001d45b).

*/
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
         int n = s.length();
        int[] shiftDelta = new int[n + 1];

        // Build the shiftDelta array
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            // Increment or decrement for the range
            shiftDelta[start] += (direction == 1) ? 1 : -1;
            shiftDelta[end + 1] -= (direction == 1) ? 1 : -1;
        }

          // Compute the prefix sum to get net shifts
        int[] netShifts = new int[n];
        int cumulativeShift = 0;
        for (int i = 0; i < n; i++) {
            cumulativeShift += shiftDelta[i];
            netShifts[i] = cumulativeShift;
        }

        // Apply the net shifts to the string
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int shift = netShifts[i] % 26; // Normalize to within range
            if (shift < 0) shift += 26;   // Handle negative shifts

            chars[i] = (char) ('a' + (chars[i] - 'a' + shift) % 26);
        }

        return new String(chars);
    }
}