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
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null || head.next==null || k==0) return head;
        ListNode dummy=head;
        int n=1;
        while (dummy.next!=null) {
            dummy=dummy.next;
            n++;
        }
        dummy.next=head;
        ListNode temp=head;
        k=k%n;
        for (int i=0; i<n-k-1; i++) {
            temp=temp.next;
        }
        ListNode mainhead=temp.next;
        temp.next=null;
        head=mainhead;
        return head;
    }
}