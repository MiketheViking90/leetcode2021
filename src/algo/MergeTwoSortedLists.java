package algo;

import datastructures.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null ^ l2 == null) {
            return l1 != null ? l1 : l2;
        }

        ListNode head = new ListNode(-1);
        ListNode pointer = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pointer.next = l1;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }

        if (l1 != null ^ l2 != null) {
            ListNode tail = (l1 != null) ? l1 : l2;
            pointer.next = tail;
        }
        return head.next;
    }
}
