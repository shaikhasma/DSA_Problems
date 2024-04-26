/*
Intuition
 The problem asks us to find the minimum sum of a falling path with non-zero shifts.
 A falling path with non-zero shifts is defined as choosing exactly one element from each row of the grid 
 such that no two elements chosen in adjacent rows are in the same column.


1. We start by recursively traversing the grid from the top row to the bottom row.
2. At each row, we calculate the minimum falling path sum for the subsequent rows 
   by recursively calling the function minFallingPathSum.
3. We maintain a Triplet object to store the minimum sum, the second minimum sum, 
   and the index of the column that yields the minimum sum for the current row.

4. For each element in the current row, 
    we calculate the sum by adding the current element to either the minimum or second minimum sum of the next row
     (depending on whether the column index matches the minimum sum index of the next row).

5. We update the Triplet object with the new minimum and second minimum sums if necessary.


Finally, we return the minimum sum of the falling path from the top row.
TC -  O(n^2 * m), n row M col

SC -  O(N)
*/
class Triplet{
    int minSum;
    int secondMinSum;
    int minSumIndex;
    
    Triplet(int minSum, int secondMinSum, int minSumIndex){
        this.minSum = minSum;
        this.secondMinSum = secondMinSum;
        this.minSumIndex = minSumIndex;
    }
}

class Solution {
     public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        return minFallingPathSum(0,grid).minSum;
    }

    private Triplet minFallingPathSum(int row, int[][] grid){

        if(row == grid.length){
            return new Triplet(0,0,0);
        }

        Triplet nextRowTriplet = minFallingPathSum(row+1, grid); //trying passing row++
        
        Triplet currentTriplet = new Triplet(Integer.MAX_VALUE, Integer.MAX_VALUE, -1);

        for(int col = 0; col<grid[0].length; col++){
            int sum = grid[row][col] + ((col != nextRowTriplet.minSumIndex) ? nextRowTriplet.minSum : nextRowTriplet.secondMinSum);

            if(sum <= currentTriplet.minSum){
                currentTriplet.secondMinSum = currentTriplet.minSum;
                currentTriplet.minSum = sum;
                currentTriplet.minSumIndex = col;
            }else if(sum < currentTriplet.secondMinSum){
                currentTriplet.secondMinSum = sum;
            }
        }

        return currentTriplet;
    }
}