class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start=0, end=0, ans=0;
        for (int i : weights) {
            start=Math.max(start, i);
            end+=i;
        }
        while (start<=end) {
            int mid=start+(end-start)/2;
            if (check(weights, mid, days)) {
                ans=mid;
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return ans;
    }
    public boolean check(int[] weights, int mid, int days) {
        int load=0, d=1;
        for (int i : weights) {
            if (load+i>mid) {
                d++;
                load=i;
            }
            else {
                load+=i;
            }
        }
        return d<=days;
    }
}