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
    int count = 0;

    int countNodes(TreeNode root) {
        if(root == null) return 0;

        int leftMax = countNodes(root.left);
        int rightMax = countNodes(root.right);

        if(root.val >= leftMax && root.val >= rightMax) {
            count += 1;
        }

        return Math.max(root.val, Math.max(leftMax, rightMax));
    }
    
    public int countDominantNodes(TreeNode root) {
        if(root == null) return 0;
        
        countNodes(root);
        return count;
    }
} 