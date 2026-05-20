class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        int[][][] dp=new int[n][m][m];
        for (int i = 0; i < n; i++) {
            for (int j1 = 0; j1 < m; j1++) {
                Arrays.fill(dp[i][j1], -1);
            }
        }
        return solve(0, 0, m-1, n, m, grid, dp);
    }
    public int solve(int i, int j1, int j2, int n, int m, int[][] grid, int[][][] dp) {
        if (j1<0 || j2<0 || j1>=m || j2>=m) return 0;
        if (i==n-1) {
            if (j1==j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }
        if (dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        int max=Integer.MIN_VALUE;
        //dono robots -1(left diagonal), 0(down), +1(right diagonal) jaa skte hain with j index
        for (int dj1=-1; dj1<=1; dj1++) {
            for (int dj2=-1; dj2<=1; dj2++) {
                int val=Integer.MIN_VALUE;
                if (j1==j2) val=grid[i][j1];
                else val=grid[i][j1]+grid[i][j2];
                val+=solve(i+1, j1+dj1, j2+dj2, n, m, grid, dp);
                max=Math.max(max, val);
            }
        }
        return dp[i][j1][j2]=max;
    }
}