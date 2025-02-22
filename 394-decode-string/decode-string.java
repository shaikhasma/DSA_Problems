/*
 String traversal (N)
 appending N * K
 TC - 0(NK)
 SC - 0(NK)
 */
class Solution {
    
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<Integer>();      
        Stack<String> stringStack = new Stack<String>();
        int number = 0;
        StringBuilder ans = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                number = number * 10 + (ch - '0');
            }
            else if(ch == '['){
                   stringStack.push(ch+"");
                   // complete number is created now push to numStack
                   numStack.push(number);
                   number = 0;
            }
            else if(ch != ']'){
                  stringStack.push(ch+"");
            }
            else{
                   
                   StringBuilder temp =  new StringBuilder();
                   while(!stringStack.peek().equals("["))
                      temp.insert(0, stringStack.pop());
                   
                   stringStack.pop();// remove [ bracket
                   
                   //multiply string with numStack value
                   int count = numStack.pop();
                   StringBuilder sb = new StringBuilder();

                   while(count >= 1){
                     sb.append(temp);
                     count--;
                   }

                   stringStack.push(sb.toString());
            }
        }
           while(!stringStack.isEmpty()){
            ans.insert(0, stringStack.pop());
           }
            return ans.toString();
    }
}