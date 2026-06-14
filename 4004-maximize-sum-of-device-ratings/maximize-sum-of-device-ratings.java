class Solution {
    public long maxRatings(int[][] units) {
        int[][] qorvelin=units;
        long sum=0;
        int minSecond=Integer.MAX_VALUE;
        int globalMin=Integer.MAX_VALUE;
        for (int[] arr : qorvelin) {
            int first=Integer.MAX_VALUE;
            int second=Integer.MAX_VALUE;
            for (int x : arr) {
                if (x<first) {
                    second=first;
                    first=x;
                } else if (x<second) {
                    second=x;
                }
            }
            globalMin=Math.min(globalMin, first);
            if (arr.length>1) {
                sum+=second;
                minSecond=Math.min(minSecond, second);
            }
        }
        if (qorvelin[0].length==1) {
            long ans=0;
            for (int[] arr : qorvelin) {
                ans+=arr[0];
            }
            return ans;
        }
        return sum-minSecond+globalMin;
    }
}