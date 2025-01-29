class Solution {
    private int[] parent;

    private int find(int x) {
        if (x != parent[x])
            parent[x] = find(parent[x]);

        return parent[x];
    }
    private void union(int x, int y) {
        parent[find(y)] = find(x);
    }

    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];
        for (int index = 0; index < parent.length; index++)
            parent[index] = index;

        for (int[] edge : edges)
            if (find(edge[0]) == find(edge[1])) 
                return edge;
            else 
                union(edge[0],edge[1]);
        return edges[0];
    }
}