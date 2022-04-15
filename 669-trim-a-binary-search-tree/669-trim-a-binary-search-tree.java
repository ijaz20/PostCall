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
    public TreeNode trimBST(TreeNode root, int low, int right) {
        if(root == null) {
            return root;
        } else if(root.val < low) {
            return trimBST(root.right, low, right);
        } else if(root.val > right) {
            return trimBST(root.left, low, right);
        }
        
        root.left = trimBST(root.left, low, right);
        root.right = trimBST(root.right, low, right);
        return root;
    }
}