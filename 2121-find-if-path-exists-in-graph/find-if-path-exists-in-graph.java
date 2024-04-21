import java.util.*;
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) 
            return  true;

        boolean[] visited = new boolean[n + 1];
        ArrayList<ArrayList<Integer>> adjList = prepareAdjList(edges, n);

        for(int index = 0; index < adjList.size(); index++){
            if(!visited[index] && index == source){
                if(dfs(index, visited, adjList, destination))
                   return true;
            }
        }

        return false;
    }

    boolean dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adjList, int destination){
        visited[node]= true;
        
        for(int neighbor : adjList.get(node)){
            if(!visited[neighbor] && neighbor == destination){
                return true;
            }else if(!visited[neighbor] )
                 if (dfs(neighbor, visited, adjList, destination)){
                    return true;
            }
        }

        return false;
    }

    ArrayList<ArrayList<Integer>> prepareAdjList(int[][] edges, int N){
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        for(int index = 0; index < N ; index++){
            adjList.add(new ArrayList<>());
        }

        for(int index = 0; index < edges.length; index++){
            int source = edges[index][0];
            int destination = edges[index][1];

            adjList.get(source).add(destination);
            adjList.get(destination).add(source);
        }

        return adjList;
    }
}