class Solution {
    public int mySqrt(int x) {
        int start=0;
        int end=x;
        int ans=1;
        while (start<=end) {
            int mid=start+(end-start)/2;
            if ((long) mid*mid<=x) {
                ans=mid;
                start=mid+1; //agar chota hai yaa equal hai toh isse bada dhundho so eliinate legft wala portion
            }
            else {
                end=mid-1;
            }
        }
        return ans;
    }
}