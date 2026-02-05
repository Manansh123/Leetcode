class Solution {
    public int totalFruit(int[] nums) {
        HashMap<Integer, Integer> mp=new HashMap<>();
        int start=0, end=0, maxlen=0;
        while (end<nums.length) {
            mp.put(nums[end], mp.getOrDefault(nums[end], 0)+1);
            while (mp.size()>2) {
                mp.put(nums[start], mp.get(nums[start])-1);
                if ( mp.get(nums[start])==0) mp.remove(nums[start]);
                start++;
            }
            maxlen=Math.max(maxlen, end-start+1);
            end++;
        }
        return maxlen;
    }
}