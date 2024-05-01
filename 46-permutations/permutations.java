/* Approach - Using recurision all permutation
TC - 0(n! * n) 
SC - 0(n) + 0(n) + 0(n) temp + freq + stack auxilliary space
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
     List<List<Integer>> list = new ArrayList<>();
     boolean[] visited = new boolean[nums.length];

     solve(nums, visited, new ArrayList<Integer>(), list);
     return list; 
    }

    void solve(int[] arr, boolean[] visited, ArrayList<Integer> temp, List<List<Integer>> ans ){
       
       if(temp.size() == arr.length){
           ans.add(new ArrayList<>(temp));
           return;
       }

       for(int index = 0; index < arr.length ; index++){
            
            if(!visited[index]){
                temp.add(arr[index]);
                visited[index] = true;
                
                solve(arr, visited, temp, ans);
                
                visited[index] = false;
                temp.remove(temp.size() - 1);
            }

       }
    
    }
}