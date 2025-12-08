// Leetcode 129. Sum Root to Leaf Numbers~~

package Tree;

import javax.swing.tree.TreeNode;

public class sumofRoot {
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
    public int sumNumbers(TreeNode root) {
        return DFS(root,0);
    }
    public int DFS(TreeNode root, int totalSum){
        if(root == null){
            return 0;
        }
        totalSum = totalSum * 10 + root.val;
        if(root.left == null && root.right == null){
            return totalSum;
        }
        return DFS(root.left , totalSum) + DFS(root.right , totalSum);
    }
}
}
