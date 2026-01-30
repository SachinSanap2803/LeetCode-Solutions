/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/



// Brute force

// class Solution {

//     public void func(Node root, List<Integer> list) {
//         if(root == null) {
//             return;
//         }

//         list.add(root.val);
//         for(Node child : root.children) {
//             func(child, list);
//         }
//     }

//     public List<Integer> preorder(Node root) {
//         List<Integer> list = new ArrayList<>();
//         func(root, list);
//         return list;
//     }

// } 







// Optimal Solution

class Solution {

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Stack<Node> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()) {
            Node top = st.pop();
            list.add(top.val);

            for(int i=top.children.size()-1; i>=0 ; i--) {
                st.push(top.children.get(i));
            }
        }

        return list;
    }

} 