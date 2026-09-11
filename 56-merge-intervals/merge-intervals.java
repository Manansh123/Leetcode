class Solution {
    public int[][] merge(int[][] nums) {
        Arrays.sort(nums, (a, b) -> Integer.compare(a[0], b[0]));
        int lower=nums[0][0], upper=nums[0][1];
        List<int[]> res=new ArrayList<>();
        for (int i=1; i<nums.length; i++) {
            if (nums[i][0]<=upper) upper=Math.max(upper, nums[i][1]);
            else {
                res.add(new int[] {lower, upper});
                lower=nums[i][0];
                upper=nums[i][1];
            }
        }
        res.add(new int[] {lower, upper});
        return res.toArray(new int[res.size()][]);
    }
}