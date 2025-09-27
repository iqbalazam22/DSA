class Solution {
    int ans = (int)(-1e9);

    public int recur(TreeNode root) {
        if (root == null) return 0;

        int rootVal = root.val;
        int left = Math.max(0, recur(root.left));   // ignore negatives
        int right = Math.max(0, recur(root.right)); // ignore negatives

        int pathSum = rootVal + left + right;       // path through this node
        ans = Math.max(ans, pathSum);

        // return contribution to parent (one side only)
        return rootVal + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        recur(root);
        return ans;
    }
}
