class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        //int[] color = new int[limit + 1];
        Map<Integer, Integer> color = new HashMap<>();
        Map<Integer,Integer> uniqueColor = new HashMap<>();
        int[] ans = new int[queries.length];

        for(int q = 0; q < queries.length; q++){
            int x = queries[q][0];
            int y = queries[q][1];
            if(!color.containsKey(x)){
                color.put(x,y);
            
            }else{
                //recolor ball
                int oldColor = color.get(x);
                if( uniqueColor.get(oldColor) > 1){
                    uniqueColor.put(oldColor, uniqueColor.get(oldColor) - 1);
                }else{
                    uniqueColor.remove(oldColor);
                }
                color.put(x, y);
            }

            uniqueColor.put(y,uniqueColor.getOrDefault(y, 0) + 1);
            ans[q] = uniqueColor.size();
        }

        return ans;
    }
}