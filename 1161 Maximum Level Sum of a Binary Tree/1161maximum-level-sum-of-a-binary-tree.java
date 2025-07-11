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
    public int maxLevelSum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 1;
        int maxSum = root.val;
        int maxLevel = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            int currLevelSum = 0;

            for(int i=0; i<size; i++) {
                TreeNode temp = queue.poll();
                currLevelSum += temp.val;

                if(temp.left != null) {
                    queue.offer(temp.left);
                }

                if(temp.right != null) {
                    queue.offer(temp.right);
                }
            }

            if(currLevelSum > maxSum) {
                maxSum = currLevelSum;
                maxLevel = level;
            }

            level++;
        }

        return maxLevel;
    }
} 