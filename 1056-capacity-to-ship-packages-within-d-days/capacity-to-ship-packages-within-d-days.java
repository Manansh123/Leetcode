class Solution {
    private boolean canShip(int[] weights, int days, int mid){
        int d=1, load=0;
        for (int i : weights) {
            if (load+i>mid) {
                d++;
                load=0;
            }
            load=load+i;
        }
        return d <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int start=0, end=0; 
        for (int i : weights) {
            start=Math.max(start, i);
            end+=i;
        }
        while (start<=end) { 
            int mid= start+(end-start)/2;
            if (canShip(weights, days, mid)) {
                end = mid-1;
            } 
            else {
                start = mid + 1;
            }
        }
        return start;
    }
}