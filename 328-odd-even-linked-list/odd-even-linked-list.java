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
    public ListNode oddEvenList(ListNode head) {
        ListNode evenHead = null;
        ListNode evenTail = null;
        ListNode oddHead = null;
        ListNode oddTail = null;
        ListNode temp = head;
        int count = 1;
        while(temp != null){
            if(count % 2 == 0){
                if(evenHead == null){
                    evenHead = temp;
                    evenTail = temp;
                }else{
                    evenTail.next = temp;
                    evenTail = evenTail.next;
                }
            }else{
                if(oddHead == null){
                    oddHead = temp;
                    oddTail = temp;
                }else{
                    oddTail.next = temp;
                    oddTail = oddTail.next;
                }
            }
            count++;
            temp = temp.next;
        }
        if(evenTail != null) evenTail.next = null;
        if(oddTail != null)oddTail.next = evenHead;
        return head;
    }
}