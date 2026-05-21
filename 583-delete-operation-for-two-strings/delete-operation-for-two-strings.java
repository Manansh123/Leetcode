class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n][m];
        for (int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        int lcs=solve(0, 0, n, m, word1, word2, dp);
        return (n-lcs)+(m-lcs);
    }
    public int solve(int i, int j, int n, int m, String word1, String word2, int[][] dp) {
        if (i==n || j==m) return 0;
        if (dp[i][j]!=-1) return dp[i][j];
        if (word1.charAt(i)==word2.charAt(j)) return dp[i][j]=1+solve(i+1, j+1, n, m, word1, word2, dp);
        else return dp[i][j]=Math.max(solve(i+1, j, n, m, word1, word2, dp), solve(i, j+1, n, m, word1, word2, dp));
    }
}