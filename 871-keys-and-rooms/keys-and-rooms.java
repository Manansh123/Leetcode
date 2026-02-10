class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q=new LinkedList<>();
        boolean[] visited=new boolean[rooms.size()];
        q.add(0); //as 0 is tarting point
        visited[0]=true;
        while(!q.isEmpty()) {
            int curr=q.poll();
            for (int i=0; i<rooms.get(curr).size(); i++) {
                int neighbour=rooms.get(curr).get(i);
                if (!visited[neighbour]) {
                    visited[neighbour]=true;
                    q.add(neighbour);
                }
            }
        }
        for (boolean room : visited) if (!room) return false;
        return true;
    }
}