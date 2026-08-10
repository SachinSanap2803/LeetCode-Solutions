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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        for(int i=0; i<inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildBT(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inMap);

        return root;
    }

    public TreeNode buildBT(int[] inorder, int inStart, int inEnd, int[] postorder, int pStart, int pEnd, Map<Integer, Integer> inMap) {
        if(inStart > inEnd || pStart > pEnd) return null;

        TreeNode root = new TreeNode(postorder[pEnd]);

        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildBT(inorder, inStart, inRoot - 1, postorder, pStart, pStart + numsLeft - 1, inMap);
        root.right = buildBT(inorder, inRoot + 1, inEnd, postorder, pStart + numsLeft, pEnd - 1, inMap);

        return root;
    }
} 