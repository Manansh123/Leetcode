class Solution {
    public int fib(int n) {
        // int[] dp=new int[n+1];
        // Arrays.fill(dp, -1);
        // return fib(n, dp);
        if (n<=1) return n;
        int prev2=0;
        int prev=1;
        int dp=0;
        System.out.println(prev2);
        System.out.println(prev);
        for (int i=2; i<=n; i++) {
            dp=prev+prev2;
            prev2=prev;
            prev=dp;
        }
        return dp;
    }
    // public int fib(int n, int[] dp) {
    //     if (dp[n]!=-1) return dp[n];
    //     if (n==1 || n==0) return n;
    //     return dp[n]=fib(n-1, dp)+fib(n-2, dp);
    // }
}