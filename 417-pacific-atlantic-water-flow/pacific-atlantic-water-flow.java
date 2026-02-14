//here we will go from ocean to land not from land to ocean becuase from 1 land we have to check for both ocean but from both ocean at the border cell we will apply bfs and check for both atlantic and pacific which cells are makrde visited on both visited arrays
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
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> lst=new ArrayList<>();
        int n=heights.length;
        int m=heights[0].length;
        boolean[][] pacific=new boolean[n][m];
        boolean[][] atlantic=new boolean[n][m];
        for (int i=0; i<m; i++) {
            if (!pacific[0][i]) bfs(0, i, pacific, heights);
        }
        for (int i=0; i<n; i++) {
            if (!pacific[i][0]) bfs(i, 0, pacific, heights);
        }
        for (int i=0; i<m; i++) {
            if (!atlantic[n-1][i]) bfs(n-1, i, atlantic, heights);
        }
        for (int i=0; i<n; i++) {
            if (!atlantic[i][m-1]) bfs(i, m-1, atlantic, heights);
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> arr=new ArrayList<>(2);
                    arr.add(i);
                    arr.add(j);
                    lst.add(arr);
                }
            }
        }
        return lst;
    }
    public void bfs(int row, int col, boolean[][] visited, int[][] grid) {
        Queue<pair> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        q.add(new pair(row, col));
        visited[row][col]=true;
        while (!q.isEmpty()) {
            pair curr=q.poll();
            for (int i=0; i<4; i++) {
                int neighrow=curr.row+rowdirection[i];
                int neighcol=curr.col+coldirection[i];
                if (isvalid(neighrow, neighcol, n, m) && grid[neighrow][neighcol]>=grid[curr.row][curr.col] && !visited[neighrow][neighcol]) {
                    q.add(new pair(neighrow, neighcol));
                    visited[neighrow][neighcol]=true;
                }
            }
        }
    }
    public boolean isvalid(int row, int col, int n, int m) {
        return (row>=0 && row<n && col>=0 && col<m);
    }
}