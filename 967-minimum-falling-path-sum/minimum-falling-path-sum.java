class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[][] dp=new int[n][n];
        for (int i=0; i<n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        for (int i=0; i<n; i++) dp[0][i]=matrix[0][i];
        for (int i=1; i<n; i++) {
            for (int j=0; j<n; j++) {
                int diagright=Integer.MAX_VALUE, diagleft=Integer.MAX_VALUE;
                if (j>0) diagleft=dp[i-1][j-1];
                int down=dp[i-1][j];
                if (j<n-1) diagright=dp[i-1][j+1];
                dp[i][j]=matrix[i][j]+Math.min(Math.min(diagleft, diagright), down);
            }
        }
        int min=Integer.MAX_VALUE;
        for (int x=0; x<n; x++) min=Math.min(min, dp[n-1][x]);
        return min;
    }
}