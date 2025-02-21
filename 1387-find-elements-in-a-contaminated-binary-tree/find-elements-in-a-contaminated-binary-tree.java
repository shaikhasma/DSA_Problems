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
class FindElements {
    HashSet<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        inOrder(root, 0);
    }

    public void inOrder(TreeNode root, int newVal){
        if(root == null)    
            return;

        root.val = newVal;
        set.add(newVal);
        
       inOrder(root.left, root.val * 2 + 1);
       inOrder(root.right, root.val * 2 + 2);
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */