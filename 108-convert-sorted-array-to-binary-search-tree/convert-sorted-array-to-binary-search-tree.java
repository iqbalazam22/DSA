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
    public TreeNode recur(int start, int end, int nums[]){
        if(start > end){
            return null;
        }
        int mid = ( start + end ) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recur(start, mid-1, nums);
        root.right = recur(mid+1, end, nums);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return recur(0, nums.length-1, nums);
    }
}