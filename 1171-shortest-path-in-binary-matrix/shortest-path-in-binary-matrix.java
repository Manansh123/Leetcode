// apply multi source bfs
class Solution {
    class pair {
        int row, col;

        public pair(int row, int col) {
            this.row=row;
            this.col=col;
        }
    }

    int[] row = { -1, 0, 0, 1, -1, -1, 1, 1 };
    int[] col = { 0, 1, -1, 0, -1, 1, -1, 1 };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] == 1 || grid[n-1][m-1] == 1)
            return -1;
        boolean[][] visited = new boolean[n][m];
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(0, 0));
        visited[0][0] = true;
        int count=1; //cell counting
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                size--;
                pair curr = q.poll();
                if (curr.row == n-1 && curr.col == n-1)
                    return count;
                for (int i = 0; i < 8; i++) {
                    int neighrow = curr.row + row[i];
                    int neighcol = curr.col + col[i];
                    if (isvalid(neighrow, neighcol, n, m) && grid[neighrow][neighcol]==0 && !visited[neighrow][neighcol]) {
                        visited[neighrow][neighcol] = true;
                        q.add(new pair(neighrow, neighcol));
                    }
                }
            }
            count++;
        }
        return -1;
    }
    public boolean isvalid(int row, int col, int n, int m) {
        return (row>=0 && row<n && col>=0 && col<m);
    }
}