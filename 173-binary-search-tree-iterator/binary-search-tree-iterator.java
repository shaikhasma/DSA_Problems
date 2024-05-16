/*. 
   Approach - Using stack

   1. push root to all extream lefts

   2. hasNext () return true if stack is empty else false

   3. when we get next then 
     -- pop top node
     -- if popped.right exists then go to all its left nodes push into stack 

     TC - 0(1) 
     SC - 0(H)only adding left nodes
     
*/
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
class BSTIterator {

     private Stack<TreeNode> stack = new Stack<TreeNode>();
    
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    // whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    //next smallest number 
    public int next() {
        TreeNode tmpNode = stack.pop();
        if(tmpNode.right != null)
            pushAll(tmpNode.right);

        return tmpNode.val;
    }
    //push all left node
    private void pushAll(TreeNode node) {
        while (node != null){
            stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */