//yaham pe farthest water cell dhundhenge for any land and likha hai find a water cell that its distance to the nearest water cell is maximum toh mtllb humme sbse badi distance find krni hai from 1(land)
class Solution {
    class pair {
        int row;
        int col;

        public pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int[] rowdirection = { -1, 0, 0, 1 };
    int[] coldirection = { 0, 1, -1, 0 };

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int countone = 0, countzero = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    q.add(new pair(i, j));
                    visited[i][j] = true;
                    countone++;
                }
                if (grid[i][j] == 0)
                    countzero++;
            }
        }
        if (countone == 0 || countzero == 0) return -1; //in constraints it is given that the smallest size will be 1 so there is a probability that it is either 1 or 0
        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean flag = false;
            while (size > 0) {
                pair curr = q.poll();
                size--;
                for (int i = 0; i < 4; i++) {
                    int neighrow = curr.row + rowdirection[i];
                    int neighcol = curr.col + coldirection[i];
                    if (isvalid(neighrow, neighcol, n, m) && grid[neighrow][neighcol] == 0
                            && !visited[neighrow][neighcol]) {
                        q.add(new pair(neighrow, neighcol));
                        visited[neighrow][neighcol] = true;
                        flag = true;
                    }
                }
            }
            if (flag) dist++; //har ek bfs kke level pe hoga
        }
        return dist;
    }

    public boolean isvalid(int row, int col, int n, int m) {
        return (row >= 0 && row < n && col >= 0 && col < m);
    }
}