package List;

public class ReverseLinkedList92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode current = temp;

        for (int i = 1; i < left; i++) {
            current = current.next;
        }
        ListNode prev = current;
        ListNode start = prev.next;

        current = start;
        for (int i = left; i < right; i++) {
            current = current.next;
        }
        ListNode end = current;
        ListNode after = end.next;

        prev.next = null;
        end.next = null;

        ListNode reversed = reverseList(start);

        prev.next = reversed;
        start.next = after;

        return temp.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
