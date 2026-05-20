class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[][] dp=new int[n][n];
        for (int i=0; i<n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        int min=Integer.MAX_VALUE;
        for (int x=0; x<n; x++) min=Math.min(min, solve(0, x, n, matrix, dp));
        return min;
    }
    public int solve(int i, int j, int n, int[][] matrix, int[][] dp) {
        if (j<0 || j>=n) return Integer.MAX_VALUE;
        if (i==n-1) return matrix[i][j];
        if (dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];
        int diagleft=solve(i+1, j-1, n, matrix, dp);
        int down=solve(i+1, j, n, matrix, dp);
        int diagright=solve(i+1, j+1, n, matrix, dp);
        dp[i][j]=matrix[i][j]+Math.min(Math.min(diagleft, diagright), down);
        return dp[i][j];
    }
}