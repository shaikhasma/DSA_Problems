/*
[4,3,2,1]

[1,3] [4,2,1,0]
[0,2]. [3 1 0 0]
TC - 0(Q*N)
SC - 0(1)

4,3,2,1]
       0.    3
[1,3] [3,2,2,0,0]
[0,2]. [3,2,1,1]
HashMap
0 1 
1 2
2 2
3 1

0(Q + N)
0(Q)


[4,3,2,1]
[1,2,0,-1]
count = 1
       0.    3

[1,3] [3,2,2,0,0]
[0,2]. [3,2,1,1]

[1,0,1],
[1 0 0 0]
[0,2]


*/
class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            diff[l]++;
            if (r + 1 < n) {
                diff[r + 1]--;
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += diff[i];
            if (nums[i] > cnt) {
                return false;
            }
        }

        return true;
    }
}