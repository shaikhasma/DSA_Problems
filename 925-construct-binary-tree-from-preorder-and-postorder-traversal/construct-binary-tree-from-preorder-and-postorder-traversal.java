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

           0(N) each node from preorder[] once time
           0(N) each time calcualting leftsub tree size from postorder[]
    TC - 0(N^2)
    SC - 0(N) stack space
code - 
class Solution {
    int[] preorder;
    int[] postorder;
    int n;
    
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.preorder = preorder;
        this.postorder = postorder;
        this.n = preorder.length;

        return sol(0, n-1, 0);    
    }

    private TreeNode sol(int preStart, int preEnd, int postStart){
        if(preStart > preEnd) 
            return null;
        if(preStart == preEnd) 
            return new TreeNode(preorder[preStart]);
       
        //Find Left Subtree Size
        //1. Identify the Left Subtree Root
        int leftroot = preorder[preStart+1];
        //Find the Size of Left Subtree (nleft)
        int nleft = 1;
        while(postorder[postStart + nleft -1] != leftroot) 
            nleft++;

        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = sol(preStart + 1, preStart + nleft, postStart);
        root.right = sol(preStart + nleft + 1, preEnd, postStart + nleft);
        return root;
    }
}
-------------------------------------------------------------------------------------------------------
Approach - 2 Using Hashing
1. We iterate over the postorder array once and store the index of each node in a HashMap (postIndexMap).
    {
        4 → 0,
        5 → 1,
        2 → 2,
        6 → 3,
        7 → 4,
        3 → 5,
        1 → 6
    
    }
postIndexMap.get(6); // Returns 3

2. Finding the Number of Left Subtree Nodes Efficiently
    int leftRoot = preorder[preS + 1]; 
    int nleft = postIndexMap.get(leftRoot) - postS + 1; // O(1) lookup


Precomputing the postorder indices: O(N)
Each recursive call now takes: O(1) for nleft lookup
Total Recursive Calls: O(N)
Final Complexity: O(N) + O(N) = O(N)

TC - 0(N)
SC - 0(N) stack space

*/        
class Solution {
    private int[] preorder;
    private int[] postorder;
    private Map<Integer, Integer> postIndexMap;
    
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.preorder = preorder;
        this.postorder = postorder;
        this.postIndexMap = new HashMap<>();
        
        // Precompute postorder indices for O(1) lookup
        for (int i = 0; i < postorder.length; i++) {
            postIndexMap.put(postorder[i], i);
        }

        return sol(0, preorder.length - 1, 0);
    }

    private TreeNode sol(int preS, int preE, int postS) {
        if (preS > preE) return null;
        if (preS == preE) return new TreeNode(preorder[preS]);

        int leftRoot = preorder[preS + 1]; 
        int nleft = postIndexMap.get(leftRoot) - postS + 1; // O(1) lookup

        TreeNode root = new TreeNode(preorder[preS]);
        root.left = sol(preS + 1, preS + nleft, postS);
        root.right = sol(preS + nleft + 1, preE, postS + nleft);
        return root;
    }
}




