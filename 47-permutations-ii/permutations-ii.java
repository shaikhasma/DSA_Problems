/* 
   0 1 2
   1 1 2

0 , 1, 2  takes
   [1 1 2]

1 takes
[1]


1  take
   
*/
class Solution {
     List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); 
        Arrays.sort(nums); 
	
        solve(ans, new ArrayList<>(), nums, new boolean[nums.length]); 
		
        return ans;
    }

     void solve(List<List<Integer>> ans, List<Integer> temp, int[] nums, boolean[] vis){
      if(nums.length == temp.size()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
		
        /*
			Traverse for whole array one by one.
		*/
        for(int i=0;i<nums.length; i++) {
		
            if(vis[i]) 
                continue; 
            if(i > 0 && ! vis[i-1] && nums[i] == nums[i-1]) 
                continue; 
            
            vis[i] = true;
            temp.add(nums[i]);
            
            solve(ans, temp, nums, vis); 
  
            temp.remove(temp.size() - 1);
            vis[i] = false;
        }
    }

}