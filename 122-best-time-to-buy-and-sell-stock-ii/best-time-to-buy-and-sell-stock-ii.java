/*
 0 1 2 3 4 5
[7,1,5,3,6,4]
output = 7

isBought = false
if isBought
  sell move next + false
else
  index  buy move next + true
  not buy

 profit max

 all possiblity on index plus max value after all possiblity 
 
 recursion

   0      false
f(index, isBuy)

 n return 0

 == based flag
       false
            buy -7
            not buy 0
        true
           sell 5 
           not sell 0

 0 1 2 3 4 5
[7,1,5,3,6,4]

3

-1 + 5 = 4
-3 + 6 = 3

4
 n - 1 to 0
 true false
 int[][] dp = new int[n][2] -1
-1 -1
-1 -1

*/
class Solution {
    public int maxProfit(int[] arr) {
        int[] nextRow = new int[2];
        int[] currentRow = new int[2];

        nextRow[0] = 0;
        nextRow[1] = 0;

        int profit = 0;
        for(int index = arr.length - 1; index >= 0; index-- ){
            for(int buy = 0; buy <= 1; buy++){
                if(buy == 0){
                    profit = Math.max(-arr[index]  + nextRow[1],
                           nextRow[0]);
                }
                else{
                    profit = Math.max(arr[index] + nextRow[0],
                                 nextRow[1]);
                }

                currentRow[buy] = profit;
            }
            nextRow = currentRow;
        }
        return nextRow[0];
    }
}