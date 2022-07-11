# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        q, res = [], []
        if root == None:
            return res
        q.append(root)
        while q:
            s, curr = len(q), None
            for i in range(s):
                curr = q.pop(0)
                if curr.left != None:
                    q.append(curr.left)
                if curr.right != None:
                    q.append(curr.right)
            res.append(curr.val)
        return res