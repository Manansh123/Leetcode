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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(-1, head);
        ListNode pre=dummy;
        ListNode curr=head;
        for (int i=1; i<left; i++) {
            pre=pre.next;
            curr=curr.next;
        }
        ListNode temp=curr;
        ListNode pre2=null;
        for (int i=0; i<right-left+1; i++) {
            ListNode agla=curr.next;
            curr.next=pre2;
            pre2=curr;
            curr=agla;
        }
        pre.next=pre2;
        temp.next=curr;
        return dummy.next;
    }
}