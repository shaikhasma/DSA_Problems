/*
* * Definition for a binary tree node.
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


 /* Approach 1 - BFS + level order traversal + Greedy Algo to find minimum swaps

 Time complexity Analysis - 
 --------------------------
 BFS Traversal - (O(N))

 Sorting Each Level - (O(K log K) [k is size of node at each level ]

 Summetion all level in worst case - O(NlogN) [O(sum of KlogK across all levels) here n is total levels i.e skewed tree]

 Swapping Elements - 0(N^2)
 [indexOf() worst case (O(K) per call so, 0(K^2) & Across all levels means N^2]                         

Space Analysis- 
-------------------
Queue - 0(N)
Array - 0(N) + 0(N)[temp]
      -0(N)

 TC - 0(N) + 0(KlogK) + 0(N^2)
    - 0(N^2)

 SC - 0(N) +  0(N) 
    -0(N)

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