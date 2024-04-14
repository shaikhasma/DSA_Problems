/* Appraoch - Using dijkstra algo

*/
class Pair{
    int node;
    int distance;
    
    public Pair(int node, int distance){
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
    
    ArrayList<ArrayList<Pair>> adjList = prepareAdjList(edges,n);
        
      PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.distance - b.distance);        
      int[] dist = new int[n];
      Arrays.fill(dist, Integer.MAX_VALUE);
        
      dist[0] = 0;
  
      pq.add(new Pair(0,0));
        
      while(!pq.isEmpty()){
          Pair currentNode = pq.poll();
          
          if(currentNode.distance > dist[currentNode.node]) 
              continue;
        
          for (Pair neighbor : adjList.get(currentNode.node)) {
                  
              if(currentNode.distance + neighbor.distance < dist[neighbor.node]){
                int newTime = currentNode.distance + neighbor.distance;

                // extra check to compare newTime < disappearing time of neighbour node
                  if(newTime < disappear[neighbor.node]){
                    dist[neighbor.node] = newTime;
                    pq.add(new Pair( neighbor.node , newTime));
                  }
              }
          }
      }
       
       // Make un-reachable nodes as -1
       for(int i = 0; i < n; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

    return dist;
    }

    private ArrayList<ArrayList<Pair>> prepareAdjList(int[][] edges,int n ){
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();

        for(int index = 0; index < n; index++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int source = edge[0];
            int destination = edge[1];
            int distance = edge[2];

            adjList.get(source).add(new Pair(destination, distance));
            adjList.get(destination).add(new Pair(source, distance));
        }

        return adjList;
    }
}