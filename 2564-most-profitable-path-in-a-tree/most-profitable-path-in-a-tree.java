class Solution {
    
    List<List<Integer>> adjList ;
    Map<Integer, Integer> bobPath ;
    int maxIncome = Integer.MIN_VALUE;
    boolean[] visited;
    int[] amount;
    int nodes;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
         nodes = amount.length;
         bobPath = new HashMap<>();
         visited = new boolean[nodes];
         this.amount = amount;
         
         adjList = prepareAdjList(edges);

         calculateBobPath(bob, 0);

         //clear visited map for alice before alice journey starts
         Arrays.fill(visited, false);
         aliceMaxIncome(0,0,0);//start node, time, income

         return maxIncome;
    }

    
    List<List<Integer>> prepareAdjList(int[][] edges){
        List<List<Integer>> list = new ArrayList<>();
        for(int index = 0; index <= nodes;  index++)
            list.add(new ArrayList<Integer>());

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }

        return list;
    }

    boolean calculateBobPath(int node, int time){
         visited[node] = true;
         bobPath.put(node, time);

         if(node == 0)
            return true;
         
         // traverse all neighbors
         for( Integer neighbor : adjList.get(node)){
            if(!visited[neighbor]){
                if(calculateBobPath(neighbor, time + 1))
                     return true;
            }
         }

         // backtrack undo path if not able to reach at node 0
         bobPath.remove(node);
         return false;
    }

    void aliceMaxIncome(int node, int time, int income){
        visited[node] = true;
        
        //If alice reaches first then collect full amount
        if(!bobPath.containsKey(node) || time < bobPath.get(node))
            income += amount[node];
        else if(bobPath.get(node) == time )//if both reaches at same time then share between both
            income += amount[node] / 2;
        

        //if alic reaches leaf node update max
        if(adjList.get(node).size() == 1 && node != 0)
            maxIncome = Math.max(maxIncome, income);
        
        // try all paths or neighbors
        for( Integer neighbor : adjList.get(node)){
            if(!visited[neighbor])
                aliceMaxIncome(neighbor, time + 1, income);
        }
    }

     
}