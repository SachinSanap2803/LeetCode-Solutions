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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;

        int pos = 2;
        int first = -1;
        int prevCritical = -1;

        int min = Integer.MAX_VALUE;
        int max = -1;

        while(next != null) {
            if((curr.val < prev.val && curr.val < next.val) || 
                (curr.val > prev.val && curr.val > next.val)) {
                    if(first == -1) {
                        first = pos;
                    } else {
                        min = Math.min(min, pos - prevCritical);
                        max = pos - first;
                    }

                    prevCritical = pos;
                }
            
            prev = curr;
            curr = next;
            next = next.next;
            pos++;
        }

        if(max == -1) {
            return new int[]{-1, -1};
        }

        return new int[]{min, max};
    }
} 