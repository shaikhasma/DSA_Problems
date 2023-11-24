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
    for(int index = 0; index < s.length(); index++){
        Character ch = s.charAt(index);

        if(isOpeningBracket(ch)){
            stack.push(ch);
        }else if (isClosingBracket(ch)){
            if(stack.isEmpty()){
                return false;
            }else if(isMatchingBracket( stack.peek() , ch)){
                stack.pop();
                continue;
            }else{
                return false;
            }
        }
     }
     return stack.isEmpty();
    }

    private boolean isOpeningBracket(char ch){
        return (ch == '{' || ch == '(' || ch == '[') ;
    }

    private boolean isClosingBracket(char ch){
        return (ch == '}' || ch == ')' || ch ==']');
    }

    private boolean isMatchingBracket(Character openingBracket, Character closingBracket){
        return (openingBracket == '{' && closingBracket == '}') || 
               (openingBracket == '[' && closingBracket == ']') ||
               (openingBracket == '(' && closingBracket == ')');
    }
    
}