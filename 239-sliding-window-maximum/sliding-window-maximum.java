class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> dQ = new ArrayDeque<>();
        for(int index = 0; index < nums.length; index++){
            // remvomve out of window
            if(!dQ.isEmpty() && dQ.peek() ==  index - k){
                dQ.poll();
            }
           // remove all smaller elements from last of dQ 
            while(!dQ.isEmpty() && nums[dQ.peekLast()] < nums[index]){
                dQ.pollLast();
            }
            dQ.add(index);
            if(index >= k - 1){
            list.add(nums[dQ.peek()]);
            }
        }
        return toArray(list);
    }

    private int[] toArray(ArrayList<Integer> list){
        int[] ans = new int[list.size()];
        int pos = 0;
        for(int index = 0; index < list.size(); index++){
            ans[pos++] = list.get(index);
        }
        return ans;
    }

}