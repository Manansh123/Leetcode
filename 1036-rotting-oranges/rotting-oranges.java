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
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int min = -1;
        boolean[][] visited = new boolean[n][m];
        Queue<pair> q = new LinkedList<>();
        int count = 0; //count fresh
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) { // rotten tomatoes
                    q.add(new pair(i, j));
                    visited[i][j] = true;
                }
                if( grid[i][j] == 1) count++;
            }
        }
        if (count==0) return 0;
        if (q.isEmpty())
            return -1;
        // apply level wise level order traversal
        while (!q.isEmpty()) {
            int size = q.size();
            // boolean flag=false; // to check that ki agar ek level pe koi rott hua hai yaa nhi
            while(size > 0) {
                pair curr = q.poll();
                for (int i = 0; i < 4; i++) {
                    int neighrow = curr.row + rowdirection[i];
                    int neighcol = curr.col + coldirection[i];
                    if (isvalid(neighrow, neighcol, n, m) && grid[neighrow][neighcol] == 1 && !visited[neighrow][neighcol]) {
                        q.add(new pair(neighrow, neighcol));
                        visited[neighrow][neighcol]=true;
                        count--;
                    }
                }
                size--;
            }
           min++;
        }
        if( count > 0 ) return -1;
        return min;
    }
    public boolean isvalid(int row, int col, int n, int m) {
        return (row>=0 && row<n && col>=0 && col<m) ? true : false;
    }
}