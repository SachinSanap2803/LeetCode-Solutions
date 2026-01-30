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
}
*/

// class Solution {

//     public void func(Node root, List<Integer> list) {
//         if(root == null) return;

//         for(Node child : root.children) {
//             func(child, list);
//         }

//         list.add(root.val);
//     }

//     public List<Integer> postorder(Node root) {
//         List<Integer> list = new ArrayList<>();
//         func(root, list);
//         return list;
//     }
// } 




class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Stack<Node> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()) {
            Node top = st.pop();
            list.add(top.val);

            for(Node child : top.children) {
                st.push(child);
            }
        }

        Collections.reverse(list);
        return list;
    }
} 