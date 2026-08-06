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

    private TreeNode parent_track(TreeNode root, Map<TreeNode, TreeNode> parent, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode temp = null;

        while(!q.isEmpty()) {
            TreeNode node = q.poll();

            if(node.val == start) {
                temp = node;
            }

            if(node.left != null) {
                q.offer(node.left);
                parent.put(node.left, node);
            }

            if(node.right != null) {
                q.offer(node.right);
                parent.put(node.right, node);
            }
        }

        return temp;
    }

    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        TreeNode target = parent_track(root, parent, start);

        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        q.offer(target);
        visited.put(target, true);
        int time = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            boolean burned = false;

            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();

                if(node.left != null && visited.get(node.left) == null) {
                    q.offer(node.left);
                    visited.put(node.left, true);
                    burned = true;
                }

                if(node.right != null && visited.get(node.right) == null) {
                    q.offer(node.right);
                    visited.put(node.right, true);
                    burned = true;
                }

                if(parent.get(node) != null && visited.get(parent.get(node)) == null) {
                    q.offer(parent.get(node));
                    visited.put(parent.get(node), true);
                    burned = true;
                } 
            }

            if(burned) {
                time++;
            }
        }

        return time;
    }
} 