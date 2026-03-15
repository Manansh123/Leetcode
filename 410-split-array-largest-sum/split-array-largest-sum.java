class Solution {
    public int splitArray(int[] nums, int k) {
        int start=0, end=0, ans=0;
        for (int i : nums) {
            start=Math.max(start, i);
            end+=i;
        }
        while (start<=end) {
            int mid=start+(end-start)/2;
            if (check(nums, k, mid)) {
                ans=mid;
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return ans;
    }
    public boolean check(int[] nums, int k, int mid) {
        int count=1, sum=0;
        for (int i : nums) {
            if (sum+i>mid) {
                count++;
                sum=i;
            }
            else {
                sum+=i;
            }
        }
        return count<=k;
    }
}