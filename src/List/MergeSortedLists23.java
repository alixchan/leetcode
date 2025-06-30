package List;


/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeSortedLists23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode result = null;
        for (ListNode list : lists) {
            result = mergeTwoLists(result, list);
        }
        return result;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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