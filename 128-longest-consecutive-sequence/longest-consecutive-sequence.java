class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        Set<Integer> set=new HashSet<>();
        for (int i=0; i<n; i++) {
            set.add(nums[i]);
        }
        int longest=0; 
        for (int i : set) {
            if (!set.contains(i-1)) {
                int num=i;
                int streak=1;
                while (set.contains(num+1)) {
                    num++; streak++;
                }
                longest=Math.max(longest, streak);
            }
        }
        return longest;
    }
}