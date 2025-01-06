/*
 "move" balls from left to right, and track how many ops 
  we count how many balls we got so far in cnt
  accumulate it in ops

  TC - 0(N) + 0(N)
     - 0(N)\
    
  SC - 0(1)
*/
class Solution {
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
}