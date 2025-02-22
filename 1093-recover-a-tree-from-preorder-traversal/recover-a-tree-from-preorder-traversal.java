/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int index = 0;
    public TreeNode recoverFromPreorder(String traversal) {  
        return solve(traversal, 0);
    }

    TreeNode solve(String str, int depth){
        if(index >= str.length())
            return null;
        //calculate d
        int j = index;
        int dashCount = 0;
        while(j < str.length() && str.charAt(j) == '-'){
            dashCount++;
            j++;
        }

        if(dashCount != depth) 
            return null;
        
        //means d == depth
         //start from whree dash completes
        int val = 0;
        index = j;

        while(index < str.length() && Character.isDigit(str.charAt(index))){
            val = val * 10 + (str.charAt(index) - '0');
            index++;
        }

        TreeNode node = new TreeNode(val);
        node.left = solve(str,  depth + 1);
        node.right = solve(str, depth + 1);
        return node;
    }
}