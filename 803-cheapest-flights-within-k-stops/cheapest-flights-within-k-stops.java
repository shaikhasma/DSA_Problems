/* Approach - Priority Queue

[0,1,100],
[1,2,100],
[2,0,100],
[1,3,600],
[2,3,200]
src = 0 dst = 3.    k stop = 1

0 -- 1 -- 2 -- 3
100.  100.  200. = 300 min but stops > k

0-- 1 -- 3
100.  600.  = 700 stops == k
output - 700
- start from 0 put into pq with min heap wrt cost
- 0 to 1 only one path 100. stop 1
- 1 to 2/3
  1 - 2 100 ( 100. + 100 = 200) stop 2 no need to go ahead stop > k
  1 - 3 600 (100 + 600 = 700 )ew are at destination stop 1  == k
  return 700

Priority Queue  
TC - 0(E log V)
SC - 0(V) + 0(V) 
      pq.    dist

Note Priority Queue is not required as every thing is more important with respect to stops first so
stop should be first priority to take decision and then mininmum cost

when we start traveling from src towords destination stops always stops + 1 
Therefore, 
        Queue always contains data in increasing order of stops so when we take first from q that will be always minimum

Queue
------
TC - 0(N) n number of cities
SC - 0(E + V)  + 0(N)
      graph.     Q
     

*/
class Node{
    int toCity;
    int cost;

    public Node(int toCity, int cost){
        this.toCity = toCity;
        this.cost = cost;
    }
}
class Flight{
    int stops;
    int city;
    int cost;

    public Flight(int stops, int city, int cost){
        this.stops = stops;
        this.city = city;
        this.cost = cost;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Node>> adjList = prepareGraph(flights, n);
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        Queue<Flight> q = new LinkedList<>();
        q.add(new Flight(0, src, 0));
        dist[src] = 0;

        while(!q.isEmpty()){
          Flight  flight = q.poll();

          int stops = flight.stops;
          int city = flight.city;
          int cost = flight.cost;
          
          if(stops > k ){
              continue;
          }

          for(Node neighbor : adjList.get(city)){
            int newCost = cost + neighbor.cost;
            int nextCity = neighbor.toCity;
            
            if(newCost < dist[nextCity] && stops <= k){
                dist[nextCity] = newCost;
                q.add(new Flight(stops + 1, nextCity, newCost));
            }
          }
        }

        if(dist[dst] == Integer.MAX_VALUE) 
            return -1;

        return dist[dst];

    }
    
    ArrayList<ArrayList<Node>> prepareGraph (int[][] flights, int cities){
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for(int index = 0; index < cities; index++){
            graph.add(new ArrayList<Node>());
        }

        for(int index = 0; index < flights.length; index++){
            int src = flights[index][0];
            int target = flights[index][1];
            int cost = flights[index][2];

            graph.get(src).add(new Node(target, cost));
        }
        return graph;
    }
}