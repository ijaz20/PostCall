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
    int l = -1, res = 0;
    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    
    void dfs(TreeNode root, int curr) {
        if(root == null) return;
        if(root.left == root.right){
             if(curr > l) {
                 l = curr;
                 res = root.val;
             } else if(curr == l) {
                 res += root.val;
             }
        }
        dfs(root.left, curr+1);
        dfs(root.right, curr+1);
    }
}