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
    public int minimumOperations(TreeNode root) {
        if(root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int totalSwap = 0;

        while(!q.isEmpty()){
            int levelSize = q.size();
            int[] levelElements = new int[levelSize];

            for(int index = 0; index < levelSize ; index++){
               
                TreeNode temp = q.poll();
                levelElements[index] = temp.val;
               
                
                if(temp.left != null)
                    q.add(temp.left);
                
                if(temp.right != null)
                    q.add(temp.right);
                 
            }

            totalSwap += calculteTotSwapsToSort(levelElements);
        }
        return totalSwap;
    }

    int calculteTotSwapsToSort(int[] arr){
        int countSwap = 0; 

        int[] temp = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(temp);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != temp[i]) {
                countSwap++;
                swap(arr, i, indexOf(arr, temp[i]));
            }
        }
        return countSwap;
    }

    void swap(int[] arr, int left , int right){
        int temp;
        temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private int indexOf(int[] arr, int ele) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == ele)
                return i;

        return -1;
    }
}