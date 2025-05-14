/*
Matrix Representation \U0001f4ca:
transition[i][j]: Number of character j produced by one character i.
For character i, set transition[i][(i+j)%26] = 1 for j = 1 to nums[i].
New frequencies after one transformation:
new_cnt[j] = Σ (cnt[i] * transition[i][j]) for all i.
Key Insight \U0001f4a1:
Applying one transformation is equivalent to multiplying the frequency vector by the transition matrix.
Applying t transformations is equivalent to multiplying by the matrix t times, i.e., cnt * (transition^t).
⚙️ Step 5: Optimize with Matrix Exponentiation
Since t can be up to 10^9, computing transition^t by multiplying the matrix t times is too slow (O(t * 26^3)). We can use matrix exponentiation to compute transition^t efficiently:

Matrix exponentiation uses the fact that mat^(2k) = (mat^k) * (mat^k).
We can compute transition^t in O(log t) matrix multiplications.
Each matrix multiplication (for 26x26 matrices) takes O(26^3) time.
Total time for transition^t is O(26^3 * log t).
Steps \U0001f504:
Build the transition matrix based on nums.
Compute transition^t using matrix exponentiation.
Multiply the initial frequency vector by transition^t to get the final frequencies.
Sum the frequencies to get the total length.
\U0001f504 Step 6: Handle Large Numbers with Modulo
Since the frequencies and length can grow exponentially, we need to apply modulo 10^9 + 7 at each step:

During matrix multiplication, compute each element modulo MOD.
When summing frequencies, compute the sum modulo MOD.
Ensure all intermediate calculations use long long to avoid overflow before applying modulo.
\U0001f3c1 Step 7: Finalize the Approach
Build the transition matrix based on nums.
Use matrix exponentiation to compute transition^t.
Compute the initial frequency vector from s.
Multiply the frequency vector by transition^t to get the final frequencies.
Sum the frequencies to get the total length, modulo 10^9 + 7.
\U0001f9e9 Detailed Approach
\U0001f6e0️ Step 1: Initialize Data Structures
Transition Matrix \U0001f4ca:
transition[26][26]: For each character i, set transition[i][(i+j)%26] = 1 for j from 1 to nums[i].
Frequency Vector \U0001f4cf:
cnt[26]: Count of each character in the initial string s.
Modulo Constant \U0001f522:
MOD = 10^9 + 7 to handle large results.
\U0001f680 Step 2: Matrix Exponentiation
Matrix Multiplication:
For two 26x26 matrices a and b, compute res[i][j] = Σ (a[i][k] * b[k][j]) % MOD.
Time: O(26^3).
Matrix Power:
Compute transition^t using fast exponentiation.
If t is odd, multiply the result by transition.
Square the matrix in each step.
Time: O(26^3 * log t).
\U0001f504 Step 3: Compute Final Frequencies
Multiply the initial cnt vector by transition^t:
new_cnt[j] = Σ (cnt[i] * transition^t[i][j]) % MOD.
Time: O(26^2).
\U0001f6d1 Step 4: Compute the Total Length
Sum all values in new_cnt to get the total length, modulo MOD.
Time: O(26).
Edge Cases \U0001f50d:
Single Character: If s has length 1, the approach still works.
Large t: Matrix exponentiation handles t <= 10^9 efficiently.
All nums[i] = 1: The transformation becomes a simple shift, but the approach generalizes.
\U0001f5bc️ Canvas Visualization
For s = "abcyy", t = 2, nums = [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2]:
Initial: cnt = [1,1,1,0,...,2,0] (for 'a', 'b', 'c', ..., 'y', 'z')

Transition Matrix (partial):
- 'a' (0): nums[0] = 1 → transition[0][1] = 1 ('b')
- 'b' (1): nums[1] = 1 → transition[1][2] = 1 ('c')
- 'y' (24): nums[24] = 1 → transition[24][25] = 1 ('z')
- 'z' (25): nums[25] = 2 → transition[25][0] = 1 ('a'), transition[25][1] = 1 ('b')

After t=1 (simulated):
- 'a' → 'b': cnt[1] += 1
- 'b' → 'c': cnt[2] += 1
- 'c' → 'd': cnt[3] += 1
- 'y' → 'z': cnt[25] += 2
- cnt = [0,1,1,1,0,...,2] (for "bcdzz")

After t=2 (simulated):
- 'b' → 'c': cnt[2] += 1
- 'c' → 'd': cnt[3] += 1
- 'd' → 'e': cnt[4] += 1
- 'z' → "ab": cnt[0] += 2, cnt[1] += 2
- cnt = [2,2,1,1,1,0,...0] (for "cdeabab")

Using Matrix Exponentiation:
- Compute transition^2
- Multiply with initial cnt
- Sum = 7

Output: 7
⏱️ Complexity
Time Complexity ⏳: O(|s| + 26^3 * log t)
Initialization \U0001f9e9: Compute cnt in O(|s|) time.
Matrix Exponentiation \U0001f504: O(26^3 * log t) for computing transition^t.
Final Multiplication \U0001f4cd: O(26^2) to compute new frequencies.
Total \U0001f4ca: O(|s| + 26^3 * log t).

Space Complexity \U0001f4be: O(26^2)
Transition Matrix \U0001f4c8: O(26^2) space.
Frequency Vectors \U0001f4cd: O(26) space.

\U0001f6e0️ Deep Workaround Thinking Process
\U0001f50d Initial Exploration
Naive Simulation \U0001f914:
Simulate each transformation by building the new string?
Fails because the string length grows exponentially (25^t), infeasible for t <= 10^9.

Character Tracking \U0001f504:
Track each character’s evolution over t steps?
Complex due to wrapping alphabet and large t.

Length Focus \U0001f5fa️:
Focus on character frequencies to compute length?
Promising, as we can compute the length via frequencies.

Matrix Approach \U0001f31f:
Model transformations as a linear system using a transition matrix?
Efficient, as we can use matrix exponentiation for large t.

\U0001f527 Refining the Logic
Transition Matrix \U0001f9e9:
Build a matrix where transition[i][j] is the number of j produced by i. Captures the transformation rules accurately.

Matrix Exponentiation \U0001f3c1:
Use fast exponentiation to compute transition^t in O(log t) steps.Handles large t efficiently.

Modulo Handling ⏳:
Apply MOD at each step to manage large numbers.Ensures the result fits within constraints.

Frequency Summation \U0001f4c8:
Multiply initial frequencies by transition^t to get final frequencies.Sum to get the length, avoiding string construction.
*/
import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;
    
    // Matrix multiplication
    private long[][] multiply(long[][] a, long[][] b) {
        long[][] res = new long[26][26];
        for (int i = 0; i < 26; ++i) {
            for (int k = 0; k < 26; ++k) {
                if (a[i][k] == 0) continue;
                for (int j = 0; j < 26; ++j) {
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        return res;
    }
    
    // Matrix exponentiation
    private long[][] matrixPow(long[][] mat, int power) {
        long[][] result = new long[26][26];
        for (int i = 0; i < 26; ++i) {
            result[i][i] = 1;
        }
        while (power > 0) {
            if (power % 2 == 1) {
                result = multiply(result, mat);
            }
            mat = multiply(mat, mat);
            power /= 2;
        }
        return result;
    }
    
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        // Initialize the transition matrix
        long[][] transition = new long[26][26];
        for (int c = 0; c < 26; ++c) {
            int num = nums.get(c);
            for (int j = 1; j <= num; ++j) {
                int nextChar = (c + j) % 26;
                transition[c][nextChar]++;
            }
        }
        
        // Raise the transition matrix to the t-th power
        long[][] matPow = matrixPow(transition, t);
        
        // Initialize the initial count vector
        long[] cnt = new long[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        
        // Multiply the count vector by the matrix^t
        long[] newCnt = new long[26];
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < 26; ++j) {
                newCnt[j] = (newCnt[j] + cnt[i] * matPow[i][j]) % MOD;
            }
        }
        
        // Sum all the counts
        long total = 0;
        for (long x : newCnt) {
            total = (total + x) % MOD;
        }
        return (int)total;
    }
}