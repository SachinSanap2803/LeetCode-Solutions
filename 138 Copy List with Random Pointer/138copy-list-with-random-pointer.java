/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/


// Brute force

// class Solution {
//     public Node copyRandomList(Node head) {
//         HashMap<Node, Node> map = new HashMap<>();
//         Node temp = head;

//         while(temp != null) {
//             Node newNode = new Node(temp.val);
//             map.put(temp, newNode);
//             temp = temp.next;
//         }

//         temp = head;
//         while(temp != null) {
//             Node copyNode = map.get(temp);
//             copyNode.next = map.get(temp.next);
//             copyNode.random = map.get(temp.random);

//             temp = temp.next;
//         }

//         return map.get(head);
//     }
// }






// Optimal Solution

class Solution {
    public Node copyRandomList(Node head) {
        
        // 1] Inserting a copy nodes in between
        Node temp = head;
        while(temp != null) {
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;

            temp = temp.next.next;
        }

        // 2] Connecting the random pointer
        temp = head;
        while(temp != null) {
            Node copy = temp.next;
            if(temp.random != null) {
                copy.random = temp.random.next;
            } else {
                copy.random = null;
            }

            temp = temp.next.next;
        }

        // 3] Connecting the next pointer and restore the original list
        Node dummy = new Node(-1);
        Node ans = dummy;
        temp = head;
        while(temp != null) {
            ans.next = temp.next;
            ans = ans.next;

            temp.next = temp.next.next;
            temp = temp.next;
        }

        return dummy.next;
    }
} 