/* 
Approach - Two pointer
TC - 0(N2)
SC - 0(1)
 public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        for (int i = 0; i < dominoes.length; i++) {
            for (int j = i + 1; j < dominoes.length; j++) {
                int a = dominoes[i][0], b = dominoes[i][1];
                int c = dominoes[j][0], d = dominoes[j][1];
                if ((a == c && b == d) || (a == d && b == c)) {
                    count++;
                }
            }
        }
        return count;
}
-------------------------------------------------------------------------
Approach - 2 Using map
This approach is simple where we simply store all the pairs in the same format in a pair map 
and then count the frequencies at the end.
We store all the pairs in increasing order of the values, that is, for the pair (a, b) if (a < b) then we store it as (b, a).
This is because it stores all the identical pairs at one place, which means all pairs containing (a, b) or (b, a) will be counted together.
\U0001f552 Time Complexity  → O(n)
\U0001f4be Space Complexity → O(n)

Note - 
d[x] * 10 + d[y] gives a unique number between 0 and 99 for any domino where 0 ≤ d[x], d[y] ≤ 9.
Example:
Take [2, 1]:

Since 2 > 1, it becomes: 2*10 + 1 = 21

Take [1, 2]:

Since 1 < 2, it becomes: 2*10 + 1 = 21

\U0001f449 Both [1,2] and [2,1] are stored at the same index 21 in the mpp array.


*/
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] mpp = new int[100];
        for (int[] d : dominoes) 
            if (d[0] > d[1]) mpp[d[0] * 10 + d[1]]++;
            else mpp[d[1] * 10 + d[0]]++;
        
        int count = 0;
        for (int freq : mpp)
            count += (freq - 1) * freq / 2;
        
        return count;
    }
}