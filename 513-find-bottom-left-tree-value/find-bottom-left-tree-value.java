/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int ans=0;
        Queue<TreeNode> q=new LinkedList<>();
        if (root==null) return ans;
        q.add(root);
        while (!q.isEmpty()) {
            int n=q.size();
            ans=q.peek().val;
            for (int i=0; i<n; i++) {
                TreeNode curr=q.poll();
                if (curr.left!=null) q.add(curr.left);
                if (curr.right!=null) q.add(curr.right);
            }
        }
        return ans;
    }
}