/*  
 Approach  - Using DFS
 1. Detech cycle in directed graph using dfs
 2. if found cycle there wont me any node in safe node list
    which is on the path of that particular dfs

3. if there is no cycle and we reach to terminal node then 
    mark that node as safe node

4.  last traverse all nodes and collect all safe nodes then return

TC - O(V+E)+O(V)
      dfs
SC - 0 ( N + N + N) + (N) auxillary stack
   -    visted path safenodes
*/
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] path = new boolean[graph.length];
        boolean[] safeNodes = new boolean[graph.length];

        ArrayList<ArrayList<Integer>> adjList = prepareAdjList(graph);

        for(int index = 0 ; index < graph.length; index++ ){
            if(!visited[index])
               cycleDetect(index, adjList, visited, path, safeNodes);
        }

        List<Integer> list = new ArrayList<>();
        for(int index = 0; index < graph.length; index++){
            if(safeNodes[index] == true){
                list.add(index);
            }
        }

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

     ArrayList<ArrayList<Integer>> prepareAdjList(int[][] graph){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int index = 0 ; index < graph.length; index++){
            list.add(new ArrayList<>());
        }

        for(int index = 0 ; index < graph.length; index++){

           // ArrayList<Integer> temp = new ArrayList<>();
            for(int neighbor : graph[index]){
                list.get(index).add(neighbor);
            }
        }

        return list;
    }
}