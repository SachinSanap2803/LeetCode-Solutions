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
    int maxZigZag = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root.left, 1, true);
        dfs(root.right, 1, false);

        return maxZigZag;
    }

    private void dfs(TreeNode root, int count, boolean isLeft) {
        if(root == null) {
            return;
        }

        maxZigZag = Math.max(maxZigZag, count);

        if(isLeft) {
            dfs(root.right, count+1, false);
            dfs(root.left, 1, true);
        } else {
            dfs(root.left, count+1, true);
            dfs(root.right, 1, false);
        }
    }
} 