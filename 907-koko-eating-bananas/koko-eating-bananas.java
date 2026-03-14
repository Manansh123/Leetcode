class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start=1;
        int end=0;
        int ans=end;
        for (int i : piles) end=Math.max(end, i);
        while (start<=end) {
            int mid=start+(end-start)/2;
            if (check(h, piles, mid)) {
                ans=mid;
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return ans;
    }
    public boolean check(int h, int[] piles, int mid) {
        long temp=0;
        if (h<=temp) return false;
        for (int i : piles) {
            temp+=(i+mid-1)/mid;
        }
        return temp<=h; //mtlb jo counted hours hain is that smaller or equal to the given hours
    }
}