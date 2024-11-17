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
       List<Integer> list = new ArrayList<>();

       TreeNode current = root;

       while(current != null){
        //case 1 - if left null 
        if(current.left == null){
            list.add(current.val);
            current = current.right;
        }
        else{
            //case - goto right most node of left subtree
            TreeNode temp = current.left;

            while(temp.right != null && temp.right != current){
                temp = temp.right;
            }

            // if link is not exist then create
            if(temp.right == null){
                temp.right = current;
                current = current.left;
            }else{
                temp.right = null;
                list.add(current.val);
                current = current.right;
            }
        }
       }
       return list;
    }
}