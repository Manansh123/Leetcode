class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for (int i=0; i<isConnected.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i=0; i<isConnected.length; i++) {
            for (int j=0; j<isConnected.length; j++) {
                if (isConnected[i][j]==1) {
                    int from=i;
                    int to=j;
                    adj.get(from).add(to);
                }
            }
        }
        int count=0;
        boolean[] visited=new boolean[isConnected.length];
        for (int i=0; i<visited.length; i++) {
            if (!visited[i]) {
                count++;
                dfs(adj, visited, i);
            } 
        }
        return count;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int start) {
        visited[start]=true;
        for (int i=0; i<adj.get(start).size(); i++) {
            int neighbour=adj.get(start).get(i);
            if (!visited[neighbour]) {
                visited[neighbour]=true;
                dfs(adj, visited, neighbour);
            }
        }
    }
}