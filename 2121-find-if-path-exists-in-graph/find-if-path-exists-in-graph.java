class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source==destination) return true;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        //converting edges to adjacency list
        for (int i=0; i<edges.length; i++) {
            int from=edges[i][0];
            int to=edges[i][1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        boolean[] visited=new boolean[n];
        return dfs(destination, source, adj, visited);
    }
    public boolean dfs(int destination, int curr, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[curr]=true;
        for (int i=0; i<adj.get(curr).size(); i++) {
            int neighbour=adj.get(curr).get(i);
            if (neighbour==destination) return true;
            if (!visited[neighbour]) {
                if (dfs(destination, neighbour, adj, visited)) return true; //this will give that is there any path till the destination
            }
        }
        return false;
    }
}