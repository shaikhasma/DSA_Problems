/* Approach - 1 Brute force
[2,0,2] ==> [0,2,1], [0,2,1], [1,1,3]
[1 0 1]  1
[0 0 0]  2

output = 2

 [4,3,2,1] ==> [[1,3,2],[0,2,1]]
 [4 1 0 0]  ==> 1
 [2 0 0 0]  ==> 2 but all are not zero 

 output = -1;
1. If all are alredy Zero mark and return zero
2. start from query[0] to query[1]
    val = query[2] 
    //if zero count it
   if(arr[index] == 0)
      dont neet to do any thing continue for next

   if arr[index] > val
      arr[index] -= val
   else
      arr[index] = 0;
3. once all are queries done 
   - check count of zero 
   - if equal to zero 
            return totalOperration
   else 
            return zero

TC - 0(Q*N)
SC - 0(N)

*/
class Solution {

    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, sum = 0, k = 0;
        int[] differenceArray = new int[n + 1];

        // Iterate through nums
        for (int index = 0; index < n; index++) {
            // Iterate through queries while current index of nums cannot equal zero
            while (sum + differenceArray[index] < nums[index]) {
                k++;

                // Zero array isn't formed after all queries are processed
                if (k > queries.length) {
                    return -1;
                }
                int left = queries[k - 1][0], right = queries[k - 1][1], val =
                    queries[k - 1][2];

                // Process start and end of range
                if (right >= index) {
                    differenceArray[Math.max(left, index)] += val;
                    differenceArray[right + 1] -= val;
                }
            }
            // Update prefix sum at current index
            sum += differenceArray[index];
        }
        return k;
    }
}