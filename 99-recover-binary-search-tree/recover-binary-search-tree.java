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
//     public void recoverTree(TreeNode root) {
//         List<Integer> list = new ArrayList<>();
//         inorder(root, list);

//         Integer first = null;
//         Integer second = null;

//         for(int i=1; i<list.size(); i++) {
//             if(list.get(i) < list.get(i-1)) {
//                 if(first == null) {
//                     first = list.get(i-1);
//                 }

//                 second = list.get(i);
//             }
//         }
        
//         updateTree(root, first, second);
//     }

//     void inorder(TreeNode root, List<Integer> list) {
//         if(root == null) return;

//         inorder(root.left, list);
//         list.add(root.val);
//         inorder(root.right, list);
//     }

//     void updateTree(TreeNode root, int first, int second) {
//         if(root == null) return;

//         updateTree(root.left, first, second);

//         if(root.val == first) root.val = second;
//         else if(root.val == second) root.val = first;

//         updateTree(root.right, first, second);
//     }
// }







// Optimized Solution

class Solution {
    TreeNode prev = null, first = null, second = null;

    public void recoverTree(TreeNode root) {
        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    void inorder(TreeNode root) {
        if(root == null) return;

        inorder(root.left);

        if(prev != null && root.val < prev.val) {
            if(first == null) {
                first = prev;
            }
            second = root;
        }

        prev = root;

        inorder(root.right);
    }
} 