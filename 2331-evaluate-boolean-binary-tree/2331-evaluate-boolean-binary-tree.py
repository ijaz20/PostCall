# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def evaluateTree(self, root: Optional[TreeNode]) -> bool:
        if root.left == root.right:
            return False if root.val ==0 else True
        l, r = self.evaluateTree(root.left), self.evaluateTree(root.right)
        return (l | r) if root.val == 2 else (l & r)