
class Solution {
    public void reorderList(ListNode head) {
        // finding middle of LL
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;

        // Reversing LL
        ListNode prev = null;
        ListNode curr = second;
        
        while(curr != null){
            ListNode next = curr.next;
            next = curr.next;
            curr.next = prev;
            prev  = curr;
            curr = next;
        }

        //merger alternately
       ListNode first = head;
       second = prev;
        while(second != null){
           ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }
}
