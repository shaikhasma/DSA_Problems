/*
            0 1 2 3 4 5
leftZero = [1 1 1 1 2 2]
rightOne = [4 4 3 2 1 1]

arr =      [0 1 1 1 0 1]

start 0 end = index, start =  end + 1  end = N - 1

index = 0     1 + 4 = 5
index = 1.    1 + 3 = 4
index 2       1 + 2 = 3
index 3.      1 + 1 = 2
index 4.      2 + 1 = 3


approach 1 - prefix array left zero & right one
1. prepare both prefix array leftZero & righOne
2. traverse both array find leftZero[index] + rightOne[index]
   maintain max sum 
3. return max sum

            0 1 2 3 4 5
leftZero = [1 1 1 1 2 2]
rightOne = [4 4 3 2 1 1]

index = 0
part 1 start at index leftZero
part 2 start at index + 1 righOne

TC - 0(N) + 0(N) + 0(N) = 3N
   - 0(N)
SC - 0(N) + 0(N) 2N
   - 0(N)


    


*/
class Solution {
    public int maxScore(String s) {
       int n = s.length();
       int[] rightOne = rightOnePrefix(s);
       int[] leftZero = leftZeroPrefix(s);

       int maxSum = 0;

        for(int index = 0; index < n - 1;  index++){
            maxSum = Math.max(maxSum, leftZero[index] + rightOne[index + 1]);
        }

        return maxSum;

    }

    int[] leftZeroPrefix(String s){
         int n = s.length();
         int[] leftZero = new int[n];

         leftZero[0] = s.charAt(0) == '0' ? 1 : 0;

         for(int index = 1; index < n; index++){
            leftZero[index] = s.charAt(index) == '0' ? leftZero[index - 1] + 1 : leftZero[index - 1];
         }

         return leftZero;
    }

    int[] rightOnePrefix(String s){
         int n = s.length();
         int[] rightOne = new int[n];

         rightOne[n - 1] = s.charAt(n - 1) == '1' ? 1 : 0;

         for(int index = n - 2; index >= 0; index--){   
             rightOne[index] = s.charAt(index) == '1' ? rightOne[index + 1] + 1 : rightOne[index + 1];
         }

         return rightOne;
    }
}