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


// Brute force

// class Solution {
//     public int pathSum(TreeNode root, int targetSum) {
//         if(root == null) return 0;

//         return countFromNode(root, targetSum)
//                + pathSum(root.left, targetSum)
//                + pathSum(root.right, targetSum);
//     }

//     private int countFromNode(TreeNode node, int remSum) {
//         if(node == null) return 0;
//         int count = 0;

//         if(node.val == remSum) {
//             count++;
//         }

//         count += countFromNode(node.left, remSum - node.val);
//         count += countFromNode(node.right, remSum - node.val);

//         return count;
//     }
// } 








// Optimal Solution

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> preSum = new HashMap<>();
        preSum.put(0L, 1);

        return dfs(root, 0, targetSum, preSum);
    }

    private int dfs(TreeNode node, long currSum, int target, HashMap<Long, Integer> preSum) {
        if(node == null) {
            return 0;
        }

        currSum += node.val;

        int count = preSum.getOrDefault(currSum - target, 0);

        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        count += dfs(node.left, currSum, target, preSum);
        count += dfs(node.right, currSum, target, preSum);

        preSum.put(currSum, preSum.get(currSum) - 1);

        return count;
    }
} 