class Solution {
    public int climbStairs(int n) {
        if (n<=2) return n;
        int dp1=1;
        int dp2=2;
        int curr=0;
        for (int i=3; i<=n; i++) {
            curr=dp2+dp1;
            dp1=dp2;
            dp2=curr;
        }
        return curr;
    }
}