package algo;

import datastructures.ListNode;

public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
