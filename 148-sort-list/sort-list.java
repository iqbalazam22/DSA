class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        // find mid
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);

    }
    public ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while(left != null && right != null){
           if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        if (left != null) {
            tail.next = left;
        } else {
            tail.next = right;
        }
        return dummy.next;
    }
}