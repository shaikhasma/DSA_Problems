/*
  Approach - greedy Algo
  TC - 0(logN + logN) + max(g,s)
      - 0(log N) + max(g,s)
  SC - 0(1)
  [7,8,9,10] child
  [5 6 7 8].  cookies

  */
class Solution {
    public int findContentChildren(int[] child, int[] cookies) {
        Arrays.sort(child);
        Arrays.sort(cookies);

        int left = 0;
        int right = 0;

        while( left < cookies.length && right < child.length){
            if(cookies[left] >= child[right]){
               left++;
               right++;
            }
            else{
                left++;
            }
        }

        return right;
    }
}