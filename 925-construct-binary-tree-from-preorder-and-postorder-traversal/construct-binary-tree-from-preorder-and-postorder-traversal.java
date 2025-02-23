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
/*
    D. L
       D L R
DLR [1,2,4,5,3,6,7]
LRD [4,5,2,6,7,3,1]
               R D
           L R D
*/        
class Solution {
   int preIndex = 0;
   int postIndex = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return solve(preorder,postorder);
    }

    TreeNode solve(int[] preOrder, int[] postOrder){
        TreeNode node = new TreeNode(preOrder[preIndex++]);

        if(node.val != postOrder[postIndex]){ // ensure not leaf
            node.left = solve(preOrder, postOrder);
        }
        if(node.val != postOrder[postIndex]){ //ensure not leaf
            node.right = solve(preOrder, postOrder);
        }

        postIndex++; // move postorder index
        return node;
    }
}