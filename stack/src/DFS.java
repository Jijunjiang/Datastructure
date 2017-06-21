import java.util.*;

/**
 * Created by apple on 16/04/2017.
 */

// 经典例题一
// print all the subset of S = {'a', 'b', 'c'}
// n store number of pair of () could be added
public class DFS {

    public static void main(String arg[]) {
//        ArrayList<Character> arrstring = new ArrayList<>();
//        DFC(3,0,0,arrstring);

//
//        link1 list = new link1();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.printList();
//        list.insert(2);
//        list.printList();

//        queuestack que = new queuestack();
//        que.offer(2);
//        que.offer(5);
//        que.offer(1);
//        System.out.println(que.peek());
//        System.out.println(que.poll());
//        System.out.println(que.peek());
//        System.out.println(que.size());

//        minstack stack = new minstack();
//        System.out.println(stack.min());
//        stack.push(1);
//        System.out.println(stack.min());
//        stack.push(2);
//        System.out.println(stack.min());
//        stack.push(-1);
//        System.out.println(stack.min());
//        stack.push(1);
//        System.out.println(stack.min());
//        stack.pop();
//        System.out.println(stack.min());
//        stack.pop();
//        System.out.println(stack.min());

        LinkedNode L = new LinkedNode(5);
        L.next = new LinkedNode(4);
        L.next.next = new LinkedNode(3);
        L.next.next.next = new LinkedNode(2);

        reverseLinkedlist r = new reverseLinkedlist();
        r.LinkedPrint(L);

        r.LinkedPrint(r.reverse(L));




    }

    public static void DFC (int n, int l, int r, ArrayList<Character> arrstring) {
        if (l + r == 2 * n) {
            System.out.println(arrstring.toString());
            return;
        }
        //case 1: number of pair is not saturate, could add '('
        if (l < n) {
            arrstring.add('(');
            DFC(n, l + 1, r, arrstring);
            arrstring.remove(arrstring.size() - 1);
        }

        if (r < l) {
            arrstring.add(')');
            DFC(n, l,r + 1, arrstring);
            arrstring.remove(arrstring.size() - 1);
        }
    }



}



//经典例题3
