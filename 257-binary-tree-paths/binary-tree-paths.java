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
    public void helper(TreeNode root, String s, List<String> arr) {
        if (root==null) return;
        if (root.left==null && root.right==null) {
            s+=root.val;
            arr.add(s);
        }
        helper(root.left, s+root.val+"->", arr);
        helper(root.right, s+root.val+"->", arr);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> arr=new ArrayList<>();
        String s="";
        helper(root, s, arr);
        return arr;
    }
}