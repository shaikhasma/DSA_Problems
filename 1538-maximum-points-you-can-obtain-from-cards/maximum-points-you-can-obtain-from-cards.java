/* Apporach - Sliding Window
1. Traval  0 to K- 1  & take summation as left sum
2. Traveal k-1 to 0 shrink the window  & start right from last element N-1
   -- lefsum -= current index element 
   -- move current index to left side by one
   
   -- rightSum+= right element
      right--

  -- Take maxSum ( previous max sum , leftSum + rightSum)

return max sum

TC - 0()
TC

*/
class Solution {
    public int maxScore(int[] cardPoints, int k) {
    int leftSum = 0;
    int rightSum = 0;
    int right = cardPoints.length - 1;
    int maxPoints = 0;

    for(int index = 0; index < k ; index++){
          leftSum += cardPoints[index];
    }

    maxPoints = leftSum;

    for(int index = k - 1; index >= 0; index--){
        leftSum -= cardPoints[index];
        rightSum += cardPoints[right];
        right--;
        
        maxPoints = Math.max(maxPoints, leftSum + rightSum);
    }
    return maxPoints;

    }
}