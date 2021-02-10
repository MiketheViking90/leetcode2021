package algo;

import datastructures.ListNode;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = null;
        ListNode runner = null;
        boolean carry = false;

        while (l1 != null && l2 != null) {
            int val = carry ? 1 : 0;
            val += (l1.val + l2.val);
            if (val >= 10) {
                val -= 10;
                carry = true;
            }

            if (sum == null) {
                sum = new ListNode(val);
                runner = sum;
            } else {
                runner.next = new ListNode(val);
                runner = runner.next;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null || l2 != null) {
            ListNode tail = l1 != null ? l1 : l2;
            while (tail != null) {
                int val = carry ? 1 : 0;
                carry = false;
                val += tail.val;
                if (val >= 10) {
                    val -= 10;
                    carry = true;
                }

                runner.next = new ListNode(val);
                runner = runner.next;

                tail = tail.next;
            }
        }

        if (carry) {
            runner.next = new ListNode(1);
        }
        return sum;
    }


    public static void main(String[] args) {
        ListNode l1 = ListNode.fromArray(new int[]{9,9,9,9,9,9,9});
        ListNode l2 = ListNode.fromArray(new int[]{9,9,9,9});

        System.out.println(l1);
        System.out.println(l2);

        ListNode sum = addTwoNumbers(l1, l2);
        System.out.println(sum);
    }
}
