/* 
Approach1  - using prefix + suffix array
1. prefixCount and prefixSum == left to right traversal  
2. suffixCount and suffixSum == right to left traversal  

   - prefixCount counts how many balls are on left side boxes vice versa for suffixCount
   - prefixSum sum/ frequency of all balss on left side vice versa for suffixSum
3. Total operations for each box are the sum of operations from the prerfix and suffix traversal
TC - 0(N) + 0(N)
     0 (N)
SC - 0(N) + 0(N)
     0 (N)


 "move" balls from left to right, and track how many ops 
  we count how many balls we got so far in cnt
  accumulate it in ops

  TC - 0(N) + 0(N)
     - 0(N)\
    
  SC - 0(1)

 public int[] minOperations(String boxes) {
        int[] res = new int[boxes.length()];
        
        for (int i = 0, ops = 0, cnt = 0; i < boxes.length(); ++i) {
            res[i] += ops;
            cnt += boxes.charAt(i) == '1' ? 1 : 0;
            ops += cnt;
        }    

        for (int i = boxes.length() - 1, ops = 0, cnt = 0; i >= 0; --i) {
            res[i] += ops;
            cnt += boxes.charAt(i) == '1' ? 1 : 0;
            ops += cnt;
        }

        return res;
    }
  
*/
class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] distances = new int[n];

        int prefixCount = 0;
        int prefixSum = 0;

        for (int i = 0; i < n; ++i) {
            distances[i] = prefixCount * i - prefixSum;
            if (boxes.charAt(i) == '1') {
                ++prefixCount;
                prefixSum += i;
            }
        }

        int suffixCount = 0;
        int suffixSum = 0;

        for (int i = n - 1; i >= 0; --i) {
            distances[i] += suffixSum - suffixCount * i;
            if (boxes.charAt(i) == '1') {
                ++suffixCount;
                suffixSum += i;
            }
        }

        return distances;
    }
}