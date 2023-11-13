class Solution {
    public int largestRectangleArea(int[] height) {
        int[] prevSmall = prevSmaller(height);
        int[] nextSmall = nextSmaller(height);
       int maxArea = Integer.MIN_VALUE;
   
       for(int index = 0; index < height.length; index++){
           if(nextSmall[index] == -1){
               nextSmall[index] = height.length;
           }
           int width = nextSmall[index] - prevSmall[index] - 1; 
           maxArea = Math.max(maxArea, width * height[index]);
       }
       return maxArea;
    }

int[] prevSmaller(int[] height){
  int[]  ans = new int[height.length]; 
  Stack<Integer> stack = new Stack<>();

  stack.push(-1);
  for(int index = 0; index < height.length; index++){
      
      while(stack.peek() != -1 && height[stack.peek()] >= height[index]){
          stack.pop();
      }

      ans[index] = stack.peek();
      stack.push(index);
  }
  return ans;
}

int[] nextSmaller(int[] height){
    int[] ans = new int[height.length];
    Stack<Integer> stack = new Stack<>();

    stack.push(- 1);
    for(int index = height.length - 1; index >= 0 ; index--){
        
        while(stack.peek() != -1  && height[stack.peek()] >= height[index]){
           stack.pop();
        }
        ans[index] = stack.peek();
        stack.push(index);
    }
    return ans;
}
}