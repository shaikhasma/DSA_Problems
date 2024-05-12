/*  
 Approach  - Topo Sort  + Reverse AdjList

TC - O(V+E)+O(N*logN),
              sorting
SC - 0 ( N + N)
   -    indegree Q 
*/
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjList = prepareRevAdjList(graph);
        int[] indegree = calculateIndegree(adjList);

        Queue<Integer> q = new LinkedList<>();
        for( int index = 0; index < adjList.size(); index++){
            if(indegree[index] == 0)
                q.add(index);
        }

        while(!q.isEmpty()){
            Integer node = q.poll();
            list.add(node);

            for(Integer neighbor : adjList.get(node)){
                indegree[neighbor]--;

                if(indegree[neighbor] == 0){
                    q.add(neighbor);
                }
            }
        }

        Collections.sort(list);
        return list;
    }

     boolean cycleDetect(int node, ArrayList<ArrayList<Integer>> adjList,
             boolean[] visited, boolean[] path, boolean[] safeNodes){
        visited[node] = true;
        path[node] = true;
        safeNodes[node] = false;
        
        for(Integer neighbor : adjList.get(node)){
            if(!visited[neighbor]){
                if(cycleDetect(neighbor, adjList, visited, path, safeNodes)){
                    return true;
                }
            }
            else if(path[neighbor] == true){
                return true;
            }
        }
        safeNodes[node] = true;
        path[node] = false;
        return false;
     }

     ArrayList<ArrayList<Integer>> prepareRevAdjList(int[][] graph){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int index = 0 ; index < graph.length; index++){
            list.add(new ArrayList<>());
        }

        for(int index = 0 ; index < graph.length; index++){

           // ArrayList<Integer> temp = new ArrayList<>();
            for(int neighbor : graph[index]){
                list.get(neighbor).add(index);
            }
        }

        return list;
    }

    int[] calculateIndegree (ArrayList<ArrayList<Integer>> adjList){
        int[] indegree = new int[adjList.size()];
        
        for(int index = 0; index < adjList.size(); index++){
            for(Integer neighbor : adjList.get(index)){
                indegree[neighbor]++;
            }
        }
        return indegree;
    }
}