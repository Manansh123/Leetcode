//no sliding window because mnotoncity breaks bcoz there are negattive values
//and because we will not shrink wiindow for eg 4, 6 4%5 !=0 so we will shrink but we should not because there is 6 ahaead using 6+4 we get 10 which is divisible by 5
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> mp=new HashMap<>();
        mp.put(0, 1);
        int pre=0, count=0;
        for (int i=0; i<nums.length; i++) {
            pre+=nums[i];
            int remainder=pre%k;
            //jb bhi remainder negatiive aa rha hai tb hum usko positive banaayengeby adding k to remainder
            if (remainder<0) remainder+=k;
            if (mp.containsKey(remainder)) count+=mp.get(remainder);
            mp.put(remainder, mp.getOrDefault(remainder, 0)+1);
        }
        return count;
    }
}