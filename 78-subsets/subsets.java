import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] nums, int index, List<Integer> curr, List<List<Integer>> ans) {
        
        if (index == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // include current element
        curr.add(nums[index]);
        backtrack(nums, index + 1, curr, ans);

        // exclude current element
        curr.remove(curr.size() - 1);
        backtrack(nums, index + 1, curr, ans);
    }
}