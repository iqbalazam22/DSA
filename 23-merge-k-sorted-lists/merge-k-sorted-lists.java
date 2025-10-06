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
    public ListNode mergeKLists(ListNode[] lists) {
        int min = (int)(1e9);
        int idx = -1;

        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null && lists[i].val < min){
                min = lists[i].val;
                idx = i;
            }
        }
        if(idx == -1) return null;
        
        ListNode head = lists[idx];
        lists[idx] = lists[idx].next;
        head.next = mergeKLists(lists);
        return head;
    }
}