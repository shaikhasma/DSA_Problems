class Solution {
    public String clearDigits(String s) {
      Stack<Character> stack = new Stack<>();

      for(int index = 0; index < s.length(); index++){
        if(Character.isDigit(s.charAt(index)))
             stack.pop();
        else
            stack.push(s.charAt(index));
      }

      StringBuilder result = new StringBuilder();
      while (!stack.isEmpty()) 
        result.insert(0, stack.pop()); 

    return result.toString();
    }
}