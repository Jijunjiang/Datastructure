/**
 * Created by apple on 20/04/2017.
 */
import java.util.*;
class LinkedNode {
    public int value;
    public LinkedNode next;
    public LinkedNode(int val) {
        this.value = val;
        this.next = null;
    }
}

public class reverseLinkedlist {
    public LinkedNode reverse(LinkedNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedNode pre = null;
        LinkedNode cur = new LinkedNode(head.value);
        while (head!= null) {
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;



//            cur = head.next;
//            head.next = pre;
//            cur = head;
//            System.out.println(head.value);



             LinkedNode next = head.next;
             head.next = pre;
             pre = head;
             head = next;
            // System.out.println(head.value);

        }
        Deque<Integer> stack = new LinkedList<Integer>();
        return pre;
    }

    public void LinkedPrint(LinkedNode head) {
        while(head != null) {
            System.out.print(head.value);
            System.out.print("-->");
            head = head.next;
        }
        System.out.print("null\n");
    }
}
