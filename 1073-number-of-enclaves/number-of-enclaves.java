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
    public int numEnclaves(int[][] grid) { 
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int count=0;
        for (int i=0; i<m; i++) {
            if (grid[0][i]==1) {
                bfs(0, i, grid, true, visited); ///true mtlb border pe hai
            }
        }
        for (int i=0; i<n; i++) {
            if (grid[i][0]==1) {
                bfs(i, 0, grid, true, visited);
            }
        }
        for (int i=0; i<n; i++) {
            if (grid[i][m-1]==1) {
                bfs(i, m-1, grid, true, visited);
            }
        }
        for (int i=0; i<m; i++) {
            if (grid[n-1][i]==1) {
                bfs(n-1, i, grid, true, visited);
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visited[i][j] && grid[i][j]==1) {
                    count+=bfs(i, j, grid, false, visited); // false mtlb border pe nhi hai
                }
            }
        }
        return count;
    }
    public int bfs(int row, int col, int[][] grid, boolean isborder, boolean[][] visited) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<pair> q=new LinkedList<>();
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
                    if (!isborder) { //mtlb border pe nhi hai
                        count++;
                        q.add(new pair(neighrow, neighcol));
                        visited[neighrow][neighcol]=true;
                    }
                    else {
                        grid[neighrow][neighcol] = 0;
                        q.add(new pair(neighrow, neighcol));
                        visited[neighrow][neighcol]=true;
                    }
                }
            }
        }
        return count;
    }
    public boolean isvalid(int row, int col, int n, int m) {
        return (row>=0 && row<n && col>=0 && col<m) ? true : false;
    }
}