package List;

public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;

            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);

            if (head == null) {
                head = newNode;
                current = head;
            } else {
                current.next = newNode;
                current = current.next;
            }

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return head;
    }
}
