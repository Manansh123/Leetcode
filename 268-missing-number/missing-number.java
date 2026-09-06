class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int total=(n*(n+1))/2;
        int sumarr=0;
        for (int i : nums) {
            sumarr+=i;
        }
        return total-sumarr;
    }
}