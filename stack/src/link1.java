
/**
 * Created by apple on 18/04/2017.
 */

class ListNode<Integer> {
    public ListNode<Integer> next;
    public int value;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

class link1 {
    private ListNode<Integer> head;
    private ListNode<Integer> tail;
    private int size;

    public ListNode getmid(int index) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public void printList() {
        ListNode curr = head;
        while(curr != null) {
            System.out.print(curr.value);
            curr = curr.next;
        }
        System.out.print("\n");
    }

    public boolean add(int val) {

        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return true;
        }
        ListNode curr = head;
        ListNode pre = new ListNode(0);
        while(curr != null) {
            pre = curr;
            curr = curr.next;
        }
        pre.next = newNode;
        return true;
    }
    //with dummy node help
    //insert value to a sorted linkedlist
    public ListNode insert(int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode newNode = new ListNode(val);
        ListNode curr = dummy.next;
        ListNode pre = dummy;
        while (curr != null && curr.value < val) {
            pre = curr;
            curr = curr.next;
        }
        pre.next = newNode;
        newNode.next = curr;
        return dummy.next;
    }
    //without dummy node


}


