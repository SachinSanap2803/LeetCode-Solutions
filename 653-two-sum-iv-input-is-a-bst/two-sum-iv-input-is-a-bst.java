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
//     public boolean findTarget(TreeNode root, int k) {
//         ArrayList<Integer> list = new ArrayList<>();
//         inorder(root, list);

//         int start = 0, end = list.size()-1;

//         while(start < end) {
//             if(list.get(start) + list.get(end) == k) {
//                 return true;
//             } else if(list.get(start) + list.get(end) > k) {
//                 end--;
//             } else {
//                 start++;
//             }
//         }

//         return false;
//     }

//     void inorder(TreeNode root, ArrayList<Integer> list) {
//         if(root == null) return;

//         inorder(root.left, list);
//         list.add(root.val);
//         inorder(root.right, list);
//     }
// } 





// Better Solution

// class Solution {
//     public boolean findTarget(TreeNode root, int k) {
//         Set<Integer> set = new HashSet<>();

//         return inorder(root, set, k);
//     }

//     boolean inorder(TreeNode root, Set<Integer> set, int k) {
//         if(root == null) return false;

//         if(inorder(root.left, set, k)) return true;

//         if(set.contains(k - root.val)) return true;

//         set.add(root.val);

//         return inorder(root.right, set, k);
//     }
// } 






// Optimal Solution

class BSTIterator {
    private Stack<TreeNode> st = new Stack<>();
    
    // reverse -> true -> before
    // reverse -> false -> next
    boolean reverse;

    public BSTIterator(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public int next() {
        TreeNode temp = st.pop();

        if(!reverse) pushAll(temp.right);    // right -> left -> left -> left
        else pushAll(temp.left);             // left -> right -> right -> right
        
        return temp.val;
    }

    public void pushAll(TreeNode node) {
        while(node != null) {
            st.push(node);

            if(reverse == true) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;

        // next
        BSTIterator l = new BSTIterator(root, false);

        // before
        BSTIterator r = new BSTIterator(root, true);

        int i = l.next();
        int j = r.next();    // r.before()

        while(l.hasNext() && r.hasNext() && i < j) {
            if(i + j == k) return true;
            else if(i + j > k) j = r.next();
            else i = l.next();
        }

        return false;
    }
} 