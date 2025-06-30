package List;

public class MergeTwoLists21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = (l1.val < l2.val) ? l1 : l2;
        ListNode current = head;

        if (head == l1) {
            l1 = l1.next;
        } else {
            l2 = l2.next;
        }

        while (l1 != null && l2 != null) {
            ListNode nextNode = (l1.val < l2.val) ? l1 : l2;
            current.next = nextNode;
            current = nextNode;
            if (nextNode == l1) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
        }

        current.next = (l1 != null) ? l1 : l2;
        return head;
    }
}
