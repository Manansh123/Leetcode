class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited=new boolean[rooms.size()];
        dfs(0, visited, rooms);
        for (boolean room: visited) if(!room) return false;
        return true;
    }
    public void dfs(int curr, boolean[] visited, List<List<Integer>> adj) {
        visited[curr]=true;
        for (int i=0; i<adj.get(curr).size(); i++) {
            int neighbour=adj.get(curr).get(i);
            if (!visited[neighbour]) dfs(neighbour, visited, adj);
        }
    }
}