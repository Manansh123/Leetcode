class Solution {
    public int rob(int[] arr) {
        if (arr.length==1) return arr[0];
        int prev2=0;
        int prev=arr[0];
        int maxsum=0;
        for (int i=1; i<arr.length; i++) {
            int take=arr[i];
            if (i-2>-1) take+=prev2;
            int skip=prev;
            maxsum=Math.max(take, skip);
            prev2=prev;
            prev=maxsum;
        }
        return maxsum;
    }
}