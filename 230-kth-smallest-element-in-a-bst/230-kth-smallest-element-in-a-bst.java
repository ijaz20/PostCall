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
  int res = -1;
  public int kthSmallest(TreeNode root, int k) {
    dfs(root, k);
    return res;
  }
    
  int dfs(TreeNode root,int k){
        if(k > 0 && root.left !=null) k = dfs(root.left, k);
        if(--k ==0){res = root.val; return k;}
        if(k > 0 && root.right !=null)  k = dfs(root.right, k);
        return k;
  }
}