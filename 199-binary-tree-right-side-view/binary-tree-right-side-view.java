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
    int dp[];
    List<Integer> list;
    int lev = -1;
    public void recur(int level, TreeNode root){
        if(root == null) return;

        if(lev < level){
            list.add(root.val);
            lev = level;
        }
        recur(level+1, root.right);
        recur(level+1, root.left);

        return;
    }
    public List<Integer> rightSideView(TreeNode root) {
        list  = new ArrayList<>();
        recur(0, root);
        
        return list;
    }
}