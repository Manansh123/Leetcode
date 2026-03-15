class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int start=0, end=0, ans=0;
        for (int i : bloomDay) {
            start=Math.min(start, i);
            end=Math.max(end, i);
        }
        while (start<=end) {
            int mid=start+(end-start)/2;
            if (check(bloomDay, mid, m, k)) {
                ans=mid;
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return ans==0 ? -1 : ans;
    }
    public boolean check(int[] bloomDay, int mid, int m, int k) {
        int bouquetCount=0, consecutiveCount=0;
        for (int i : bloomDay) {
            if (i<=mid) {
                consecutiveCount++;
            }
            else {
                consecutiveCount=0;
            }
            if (consecutiveCount==k) {
                bouquetCount++;
                consecutiveCount=0;
            }
        }
        return bouquetCount>=m;
    }
}