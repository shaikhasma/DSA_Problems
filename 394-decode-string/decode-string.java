class Solution {
    
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<Integer>();      
        Stack<String> stringStack = new Stack<String>();
        int number = 0;
        String ans = "";

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
                   
                   String str = "";
                   while(!stringStack.peek().equals("["))
                      str = stringStack.pop() + str;
                   
                   stringStack.pop();// remove [ bracket
                   //multiply string with numStack value
                   int count = numStack.pop();
                   StringBuilder sb = new StringBuilder(str);

                   while(count > 1){
                     sb.append(str);
                     count--;
                   }
                   stringStack.push(sb.toString());
            }
        }
           while(!stringStack.isEmpty()){
            ans = stringStack.pop() + ans;
           }
            return ans;
    }
}