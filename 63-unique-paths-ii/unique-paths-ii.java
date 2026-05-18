class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        int[][] dp= new int[n][m];
        for (int i=1; i<n; i++) Arrays.fill(dp[i], -1);
        if (grid[0][0]==1) return 0;
        dp[0][0]=1;
        for (int i=1; i<m; i++) {
            dp[0][i]=(grid[0][i]==0) ? dp[0][i-1] : 0;
        }
        for (int i=1; i<n; i++) {
            dp[i][0]=(grid[i][0]==0) ? dp[i-1][0] : 0;
        }
        for (int i=1; i<n; i++) {
            for (int j=1; j<m; j++) {
                int down=0, right=0;
                if (grid[i][j]==0) {
                    if (i>0) down=dp[i-1][j];
                    if (j>0) right=dp[i][j-1];
                    dp[i][j]=down+right;
                }
                else dp[i][j]=0;
            }
        }
        return dp[n-1][m-1];
    }
}