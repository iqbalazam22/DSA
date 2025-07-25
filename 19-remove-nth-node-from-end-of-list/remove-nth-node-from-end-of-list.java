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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = null;
        ListNode temp = head;
        ListNode slow = head;
        while(n!=0){
            n--;
            temp = temp.next;
        }
        ListNode fast = temp;
        while(fast!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if(pre == null){
            head = head.next;
        }
        else {
            pre.next = pre.next.next;
        }
        return head;
    }
}