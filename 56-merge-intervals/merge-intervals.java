/* Approach 2 - Sort pairs

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
    
    sortPair(arr);      
    List<List<Integer>> interval = new ArrayList<>();
    for(int p1 = 0; p1 < arr.length; p1++){
        int start = arr[p1][0];
        int end = arr[p1][1];
        //if we dont have previous
        // if we have prevous + current start > previous.end 
        // then add as new interval
        if(interval.isEmpty() || start > interval.get(interval.size() - 1).get(1)){
            interval.add(Arrays.asList(start, end));
        }else{
            // if we have previous + current pair start is lie between previous interval
            //update previous index end here it self
            interval.get( interval.size() - 1 )
                    .set( 1, Math.max(end, interval.get(interval.  size() - 1).get(1)));
        }
    }

     return listTo2DArray(interval);
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

    void sortPair(int[][] arr){
        Arrays.sort(arr, new Comparator<>(){
          
          public int compare(int[] a, int[] b){
              return a[0] - b[0];
          }
        });
    }
}

/*   [[1,3],[2,6],[8,10],[15,18]]
     [[1,6],[8,10],[15,18]]

     start 1
     end  6

      [[1,4],[2,3],[8,10],[15,18]]
*/