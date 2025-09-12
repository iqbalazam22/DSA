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
    int count = 0;
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        count = count * 10 + root.val;
        if(root.left == null && root.right == null){
            sum += count;
        }
        sumNumbers(root.right);
        sumNumbers(root.left);
        count = count / 10;
        return sum;
    }
}