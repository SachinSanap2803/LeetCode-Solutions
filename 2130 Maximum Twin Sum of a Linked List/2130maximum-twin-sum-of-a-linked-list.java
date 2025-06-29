/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Reverse second half of the linkedlist
        ListNode secondHalf = reverseList(slow);

        // Traverse both halves and find max twin sum
        int maxSum = 0;
        ListNode firstHalf = head;
        while(secondHalf != null) {
            int tempSum = firstHalf.val + secondHalf.val;
            maxSum = Math.max(maxSum, tempSum);

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return maxSum;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}


// class Solution {
//     public int pairSum(ListNode head) {
//         ArrayList<Integer> list = new ArrayList<>();

//         while(head != null) {
//             list.add(head.val);
//             head = head.next;
//         }

//         int maxSum = 0;
//         int n = list.size();

//         for(int i=0; i<n/2; i++) {
//             int tempSum = list.get(i) + list.get(n-1-i);
//             maxSum = Math.max(maxSum, tempSum);
//         }

//         return maxSum;
//     }
// } 