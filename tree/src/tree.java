import java.util.*;
class TreeNode {
    TreeNode left;
    TreeNode right;
    int key;
    TreeNode(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}
public class tree {
    static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        treeIterat a = new treeIterat();
        TreeNode root = a.buildTree(array);
        List<Integer> result = a.preOrder(root);
        Integer[] preor = new Integer[result.size()];
        preor = result.toArray(preor);
        System.out.print(Arrays.toString(preor));
    }

    //if a tree is a binary search tree
    boolean isBinarySearch(TreeNode root) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return isBinarySearch(root, min, max);
    }
    List<Integer> a = new ArrayList<Integer>();

    boolean isBinarySearch(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (min >= root.key || root.key >= max) {
            return false;
        }

        return isBinarySearch(root.left, min, root.key)
                && isBinarySearch(root.right, root.key, max);
    }
}

class ListNode {
    int value;
    ListNode next;
    public ListNode(int value){
        this.value = value;
        this.next = null;
    }
}

class Stack {
    private ListNode head; // java 会默认 object 为 null

    public void push(int value){
        ListNode newHead = new ListNode(value);
        newHead.next = head;
        head = newHead;
    }

    public Integer pop(){
        if (!isEmpty()) {
            int value = head.value;
            head = head.next;
            return value;
        }
        return null;
    }

    public Integer peek(){ // Integer 可以返回 null
        if (!isEmpty()) {
            return head.value;
        }
        return null;
    }

    public boolean isEmpty(){
        return head == null;
    }
}




class Queue {
    private ListNode head;
    private ListNode tail;

    public boolean offer(int value) {
        ListNode newTail = new ListNode(value);
        if(head == null) {
            head = newTail;
            tail = newTail;
            return true;
        }
        tail.next = newTail;
        tail = tail.next;
        return true;
    }

    public Integer poll() {
        if (head != null) {
            int value = head.value;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return value;
        }else {
            return null;
        }
    }

    public Integer peek() {
        if(head == null) {
            return null;
        }
        return head.value;
    }

}




