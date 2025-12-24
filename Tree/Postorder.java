// Leetcode 145. Binary Tree Postorder Traversal
// Brief: DFS visits left, then right, then root to collect nodes in postorder.


import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class Postorder {
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        PostOrder(root , result);
        return result;
    }
    public void PostOrder(TreeNode root , List<Integer> result){
        if(root == null){
            return;
        }
        PostOrder(root.left , result);
        PostOrder(root.right , result);
        result.add(root.val);
        
    }
}
}
