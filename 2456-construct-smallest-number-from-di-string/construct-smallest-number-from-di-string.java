/*
Approach -  Using stack 
Iterate over the pattern:For each character in the pattern, push numbers from1ton+1onto a stack.
When 'I' is encountered or at the end:Pop the stack and append the numbers to the result.
Lexicographically Smallest:The stack is popped in reverse order when a decrease ('D') is followed, ensuring the smallest lexicographical number.
TC - 0(N)
SC - 0(N)
*/

class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        StringBuilder result = new StringBuilder();
        int[] stack = new int[n + 1]; 
        int index = 0;

        for (int i = 0; i <= n; i++) {
            stack[index++] = i + 1;

            if (i == n || pattern.charAt(i) == 'I') {
                while (index > 0) {
                    result.append(stack[--index]);
                }
            }
        }

        return result.toString();
    }
}