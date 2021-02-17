package algo;

import datastructures.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (fast == head) {
                return true;
            }
            head = head.next;
            fast = fast.next.next;
        }
        return false;
    }
}
