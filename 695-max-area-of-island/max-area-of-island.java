class Solution {
    // Function to find unit area of the largest region of 1s.
    class pair{
        int row;
        int col;
        public pair(int row, int col) {
            this.row=row;
            this.col=col;
        }
    }
    int[] rowdirection={-1, 0, 0, 1};
    int[] coldirection={0, 1, -1, 0};
    public int maxAreaOfIsland(int[][] grid) {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int area=0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j]==1 && !visited[i][j]) {
                    area=Math.max(area, bfs(i, j, grid, visited));
                }
            }
        }
        return area;
    }
    public int bfs(int row, int col, int[][] grid, boolean[][] visited) {
        Queue<pair> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        q.add(new pair(row, col));
        visited[row][col]=true;
        count++;
        while (!q.isEmpty()) {
            pair curr=q.poll();
            for (int i=0; i<4; i++) {
                int neighrow=curr.row+rowdirection[i];
                int neighcol=curr.col+coldirection[i];
                if (isvalid(neighrow, neighcol, n, m) && grid[neighrow][neighcol]==1 && !visited[neighrow][neighcol]) {
                    count++;
                    q.add(new pair(neighrow, neighcol));
                    visited[neighrow][neighcol]=true;
                }
            }
        }
        return count;
    }
    public boolean isvalid(int row, int col, int n, int m) {
        return (row>=0 && row<n && col>=0 && col<m) ? true : false;
    }
}