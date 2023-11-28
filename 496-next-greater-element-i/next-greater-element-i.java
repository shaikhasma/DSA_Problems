/* Approach : HashMap + Stack
TC: 0(n)
SC: 0(N) + 0(N)  = 0(N)
*/
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int index = 0; index < nums2.length ; index++){
            while(!stack.isEmpty() && nums2[index] >= stack.peek()){
                map.put(stack.pop(), nums2[index]);
            }
            stack.add(nums2[index]);
        }
        
        int[] ans = new int[nums1.length];
        int pos = 0;

        for(int no : nums1){
           ans[pos++] = map.getOrDefault(no,-1);    
        }
        return ans;
    }
}