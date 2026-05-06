/*
Approach 2 - Sort pairs

1. Sort pairs
2. Traverse 0 - N all pairs ( i)
   Start = 1st element
   end   = 2nd element
3. if dont have any previous interval or current start > previous end
   Add into interval list

4. if we have previous interval
   Compare - 
     previous interval ( list.size() - 1 ) with current.start <= previous.end
     if yes take mask of both the end and update the current end
TC - 0(logn) + 0(n) only one traversal
SC - 0(n)
*/
class Solution {
    public int[][] merge(int[][] arr) {
        int n = arr.length;

        // sort the givent intervals
        sortPairs(arr);

        List<List<Integer>> ans = new ArrayList<>();

        for(int index = 0; index < arr.length; index++){
            int start = arr[index][0];
            int end = arr[index][1];

            // if 1st pair and dont have previous or current start > prev end then add new interval in ans
            if(ans.isEmpty() || start > ans.get(ans.size() - 1).get(1)){
                ans.add(Arrays.asList(start, end));
            }else{
                // here we have prev pair, and can overlap 
                int maxEnd = Math.max(end, ans.get(ans.size() - 1).get(1));
                ans.get(ans.size() - 1).set(1, maxEnd);
            }
        }

        return listTo2DArray(ans);

    }

    void sortPairs(int[][] arr){
        Arrays.sort(arr, new Comparator<int[]> (){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
    }

    int[][] listTo2DArray(List<List<Integer>> list){
        int[][] arr = new int[list.size()][];
        
        for(int index = 0; index < list.size(); index++){
        
            int[] temp = new int[2];
          
            temp[0] = list.get(index).get(0);
            temp[1] = list.get(index).get(1);
          
            arr[index] = temp;
        }

       return arr;
    }
}