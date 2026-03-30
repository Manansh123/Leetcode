class Solution {
    public int tribonacci(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);
        return fib(n, dp);
    }
    public int fib(int n, int[] dp) {
        if (dp[n]!=-1) return dp[n];
        if (n==1 || n==0) return n;
        if (n==2) return 1;
        return dp[n]=fib(n-1, dp)+fib(n-2, dp)+fib(n-3, dp);
    }
}