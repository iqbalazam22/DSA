/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLen = 0;
        int bLen = 0;
        ListNode a = headA;
        ListNode b = headB;
        while(a != null){
            aLen++;
            a = a.next;
        }
        while(b != null){
            bLen++;
            b= b.next;
        }
        int len = Math.abs(aLen - bLen);
        if(aLen > bLen){
            for(int i = 0; i < len; i++) if(headA != null)headA = headA.next;
        }else{
            for(int i = 0; i < len; i++) if(headB != null)headB = headB.next;
        }
        while(headA != null && headB != null){
            if(headA == headB){
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}