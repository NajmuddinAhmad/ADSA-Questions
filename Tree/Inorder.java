// Leetcode 94. Binary Tree Inorder Traversal

package Tree;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        InOrder(root,result);
        return result;
    }
    public void InOrder(TreeNode root , List<Integer> result){
        if(root == null){
            return;
        }
        InOrder(root.left , result);
        result.add(root.val);
        InOrder(root.right , result);
        
    }
}