package datastructures;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode fromArray(int[] array) {
        if (array.length == 0) {
            return null;
        }

        ListNode head = new ListNode(array[0]);
        ListNode runner = head;
        for (int i = 1; i < array.length; i++) {
            runner.next = new ListNode(array[i]);
            runner = runner.next;
        }
        return head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode node = this;
        while (node != null) {
            String next = node.val + "->";
            sb.append(next);
            node = node.next;
        }
        return sb.toString();
    }

}
