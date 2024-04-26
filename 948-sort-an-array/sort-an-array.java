/* Approach - 3 PriorityQueue

TC - 0(N log N)
SC ( N) 

*/
class Solution {
    public int[] sortArray(int[] nums) {
        
        int[] ans = new int[nums.length];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums) 
            pq.offer(num);
        
        int index = 0;
        while(!pq.isEmpty()) 
           ans[index++] = pq.poll();

        return ans;
    }
}