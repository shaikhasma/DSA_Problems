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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        if(root == null)
            return inOrder;
        
        TreeNode current = root;

        while(current != null){
            // left subtree present
            if(current.left != null){
             TreeNode temp = current.left;
             while(temp.right != null && temp.right != current){
                temp = temp.right;
             }

             //going to left
            if(temp.right == null){
                //create link 
                temp.right = current;
                current = current.left;
            }else{
             //comming from left
              //remove link 
              temp.right = null;
              inOrder.add(current.val);
              current = current.right;
            }
        }else{
            //left subtree not available
             inOrder.add(current.val);
             current = current.right;
            }
        }
    
    return inOrder;
    }
}