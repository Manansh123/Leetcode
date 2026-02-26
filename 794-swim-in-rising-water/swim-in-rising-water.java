//undirected and weighted graph bcoz from 0 to 1 is takes 1 weight so we will apply dijkstra algo
class Solution {
    class pair {
        int row;
        int col;
        int time;

        public pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    int[] rowdirection = { -1, 0, 0, 1 };
    int[] coldirection = { 0, 1, -1, 0 };

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<pair> q = new PriorityQueue<>((a, b) -> a.time - b.time);
        q.add(new pair(0, 0, grid[0][0]));
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0]=grid[0][0];
        while (!q.isEmpty()) {
            pair curr = q.poll();
            if (curr.time > dist[curr.row][curr.col]) continue; // yeh jis nodes pe already chota hoga toh unko update nhi krta hai
            for (int i = 0; i < 4; i++) {
                int neighrow = curr.row + rowdirection[i];
                int neighcol = curr.col + coldirection[i];
                if (isvalid(neighrow, neighcol, n)) {
                    int neigh = grid[neighrow][neighcol];
                    int val=Math.max(curr.time, neigh);
                    if (val<dist[neighrow][neighcol]) {
                        dist[neighrow][neighcol]=val;
                        q.add(new pair(neighrow, neighcol, val));
                    }
                }
            }
        }
        return dist[n - 1][n - 1];
    }

    public boolean isvalid(int row, int col, int n) {
        return (row >= 0 && col >= 0 && row < n && col < n);
    }
}