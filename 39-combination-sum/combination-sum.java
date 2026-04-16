import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void solve(int[] arr, int target, int index,
                       List<Integer> curr,
                       List<List<Integer>> ans) {
        
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (index == arr.length || target < 0) {
            return;
        }

        // pick same element again
        curr.add(arr[index]);
        solve(arr, target - arr[index], index, curr, ans);

        // backtrack + skip current
        curr.remove(curr.size() - 1);
        solve(arr, target, index + 1, curr, ans);
    }
}