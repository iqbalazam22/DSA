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
    int ans = (int)(-1e9);
    public int recur(TreeNode root){
        if(root == null) return 0;
        int rootVal = root.val;
        int left = recur(root.left);
		int right = recur(root.right);
		int pathSum = rootVal + left + right;
        ans = Math.max(ans, pathSum);
        ans = Math.max(ans, rootVal);
        ans = Math.max(ans, rootVal + Math.max(left, right));
        return rootVal + Math.max(0, Math.max(left, right));
    }
    public int maxPathSum(TreeNode root) {
        int ret = recur(root);
        return ans;
    }
}