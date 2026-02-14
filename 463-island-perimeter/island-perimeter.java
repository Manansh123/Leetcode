class Solution {
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
    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int peri=0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j]==1 && !visited[i][j]) peri+=bfs(i, j, visited, grid);
            }
        }
        return peri;
    }
    public int bfs(int row, int col, boolean[][] visited, int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int peri=0;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(row, col));
        visited[row][col]=true;
        while (!q.isEmpty()) {
            pair curr=q.poll();
            int count=4;
            for (int i=0; i<4; i++) {
                int neighrow=curr.row+rowdirection[i];
                int neighcol=curr.col+coldirection[i];
                if (isvalid(neighrow, neighcol, n, m) && grid[neighrow][neighcol]==1) {
                    if (visited[neighrow][neighcol]) count--;
                    else {
                        count--;
                        q.add(new pair(neighrow, neighcol));
                        visited[neighrow][neighcol]=true;
                    }
                }
            }
            peri+=count;
        }
        return peri;
    }
    public boolean isvalid(int row, int col, int n, int m) {
        return (row>=0 && row<n && col>=0 && col<m) ? true : false;
    }
}