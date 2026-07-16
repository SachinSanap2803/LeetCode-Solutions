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
    public ListNode partition(ListNode head, int x) {
        ListNode lessDummy = new ListNode(0);
        ListNode less = lessDummy;
        ListNode greaterDummy = new ListNode(0);
        ListNode greater = greaterDummy;

        ListNode temp = head;

        while(temp != null) {
            if(temp.val < x) {
                lessDummy.next = temp;
                lessDummy = lessDummy.next;
            } else {
                greaterDummy.next = temp;
                greaterDummy = greaterDummy.next;
            }

            temp = temp.next;
        }

        lessDummy.next = greater.next;
        greaterDummy.next = null;

        return less.next;
    }
} 