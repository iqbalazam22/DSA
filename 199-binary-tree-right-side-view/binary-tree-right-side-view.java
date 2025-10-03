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
    Map<Integer, Integer> map;
    public void recur(int level, TreeNode root){
        if(root == null) return;

        if(!map.containsKey(level)){
            map.put(level, root.val);
        }
        recur(level+1, root.right);
        recur(level+1, root.left);

        return;
    }
    public List<Integer> rightSideView(TreeNode root) {
        list  = new ArrayList<>();
        map = new TreeMap<>();
        recur(0, root);
        for(Integer key : map.keySet()){
            list.add(map.get(key));
        }
        return list;
    }
}