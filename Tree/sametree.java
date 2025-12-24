// Leetcode 100. Same Tree
// Brief: Recursively compare nodes and subtrees; trees are same if all pairs match.


package Tree;

import javax.swing.tree.TreeNode;

public class sametree {
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        else if(p == null || q == null){
            return false;
        }
        else if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left , q.left) && isSameTree(p.right , q.right);
    }
}
}
