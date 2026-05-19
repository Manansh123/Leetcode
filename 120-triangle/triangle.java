class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];
        for (int i=0; i<n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[0][0]=triangle.get(0).get(0);
        for (int i=1; i<n; i++) dp[i][0]=triangle.get(i).get(0)+dp[i-1][0];
        for (int i=1; i<n; i++) {
            for (int j=1; j<=i; j++) {
                int down=Integer.MAX_VALUE, diag=Integer.MAX_VALUE;
                if (i>0) down=dp[i-1][j];
                if (i>0 && j>0) diag=dp[i-1][j-1];
                dp[i][j]=triangle.get(i).get(j)+Math.min(down, diag);
            }
        }
        int min=Integer.MAX_VALUE;
        for (int i=0; i<n; i++) min=Math.min(min, dp[n-1][i]);
        return min; 
    }
}