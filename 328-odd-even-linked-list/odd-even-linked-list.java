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

        if(head == null || head.next == null) return head;

        ListNode temp = head;

        ListNode oHead = null;
        ListNode oTail = null;

        ListNode eHead = null;
        ListNode eTail = null;
        
        int count = 0;
        while(temp != null){

            count++;

            if(count % 2 == 1){
                if(oHead == null){
                    oHead = temp;
                    oTail = temp;
                }else{
                    oTail.next = temp;
                    oTail = oTail.next;
                }
            }else{
                if(eHead == null){
                    eHead = temp;
                    eTail = temp;
                }else{
                    eTail.next = temp;
                    eTail = eTail.next;
                }
            }
            temp = temp.next;
        }
        if(eTail.next != null) eTail.next = null;
        if(oTail.next != null) oTail.next = null;

        oTail.next = eHead;

        return oHead;
    }
}