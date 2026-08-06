/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


class Solution {

    private void markParents(TreeNode root, TreeNode target, Map<TreeNode, TreeNode> parent) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            
            if(node.left != null) {
                parent.put(node.left, node);
                q.offer(node.left);
            }

            if(node.right != null) {
                parent.put(node.right, node);
                q.offer(node.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        markParents(root, target, parent);

        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(target);
        visited.put(target, true);
        int dist = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            if(dist == k) break;

            dist++;

            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();

                if(node.left != null && visited.get(node.left) == null) {
                    q.offer(node.left);
                    visited.put(node.left, true);
                }

                if(node.right != null && visited.get(node.right) == null) {
                    q.offer(node.right);
                    visited.put(node.right, true);
                }

                if(parent.get(node) != null && visited.get(parent.get(node)) == null) {
                    q.offer(parent.get(node));
                    visited.put(parent.get(node), true);
                }
            }
        }

        List<Integer> res = new ArrayList<>();

        while(!q.isEmpty()) {
            res.add(q.poll().val);
        }

        return res;
    }
} 