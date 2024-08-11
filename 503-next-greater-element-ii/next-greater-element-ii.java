//[1 2 1]
//[2 -1 2]

//0  1. 2 
//1  2  1 -- 1 2 1
//2 -1  2.  
// index  % size
// 0 % 3 = 

class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int[] ans = new int[arr.length];
        Arrays.fill(ans, -1);

        Stack<Integer> stack = new Stack<Integer>();
        int size = arr.length;
        for(int index = 2 * size - 1; index >=0; index--){
            while(!stack.isEmpty() && 
                  stack.peek() <= arr[index % size]){
                stack.pop();
            }
           
            if(index < size && !stack.isEmpty())
                ans[index] = stack.peek();
                
            stack.push(arr[index % size]);
        }
        return ans;
    }
}