/* Approach - Using stack Stack 
1. Traverse String 
2. if opening bracket push to stack
3. if closing bracket then check matching bracket found or not
  - if stack is empty return false from there it self
  - if found pop from stack continue for remaining elements 
  - if not found return false from there it self

TC - 0(n)
SC - 0(N)
*/
class Solution {
    public boolean isValid(String s) {
          Stack<Character> stack = new Stack<>();

          for(int index = 0; index < s.length() ; index++){
            Character ch = s.charAt(index);
            if(isOpening(ch)){
                stack.push(ch);
            }else if (isClosing(ch)){
                if(stack.isEmpty())
                    return false;
                else if(isMatching( stack.peek() , ch)){
                    stack.pop();
                    continue;
                }else
                    return false;
            }
          }

          return stack.isEmpty();
    }

    boolean isOpening(char ch){
        if( ch == '(' || ch== '[' || ch == '{')
          return true;

        return false;
    }
     boolean isClosing(char ch){
        if( ch == ')' || ch== ']' || ch == '}')
          return true;

        return false;
    }

    boolean isMatching(char ch1, char ch2 ){
        if( (ch1 == '('  && ch2 == ')' )
            || (ch1 == '['  && ch2 == ']' )
            || (ch1 == '{'  && ch2 == '}'))
          return true;
          
        return false;
    }

}