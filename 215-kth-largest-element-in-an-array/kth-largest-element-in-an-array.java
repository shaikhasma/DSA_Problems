/* Approach - Priority Queue

TC - 0(N + logK)
SC - 0(K)
min Heap [5. 6]
1 
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>();
        
        for(int index = 0; index < nums.length; index++){
            q.add(nums[index]);
            if(q.size() > k)
                q.poll();
        }

        return q.peek();
    }
}