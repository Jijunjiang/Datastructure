/**
 * Created by apple on 15/06/2017.
 */
class ListNode {
    int value;
    ListNode next;
    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}
public class reorder {
    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //find middle node
        ListNode mid = middleNode(head);
        ListNode one = head;
        ListNode two = mid.next;

        //de-link the second half from the list
        mid.next = null;
        //2. reverse the second half and merge two halves
        return merge(one, reverse(two));
    }

    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(one != null && two != null) {
            cur.next = one;
            one = one.next;
            cur.next.next = two;
            two = two.next;
            cur = cur.next.next;
        }
        if (one != null) {
            cur.next = one;
        } else {
            cur.next = two;
        }
        return dummy.next;
    }


    public ListNode partition(ListNode head, int target) {
        // write your solution here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode before = dummy;
        ListNode after = dummy;
        while(before.next != null && before.next.value < target) {
            before = before.next;
        }
        if (before == null) {
            return head;
        }
        after = before.next;
        while(after!= null) {
            if (after.value < target) {
                ListNode nextAfter = after.next;
                ListNode nextBefore = before.next;
                before.next = after;
                after.next = nextBefore;
                after = nextAfter;
            } else {
                after = after.next;
            }
        }

        return dummy.next;
    }
}















