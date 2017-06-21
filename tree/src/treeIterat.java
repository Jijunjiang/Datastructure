/**
 * Created by apple on 18/06/2017.
 */
import java.util.*;
import java.util.Queue;

public class treeIterat {
    static public void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        TreeNode root = buildTree(array);
        List<Integer> result = inOrder(root);
        Integer[] preor = new Integer[result.size()];
        preor = result.toArray(preor);
        System.out.print(Arrays.toString(preor));

    }
    static public TreeNode buildTree(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
       for (int i = 0; i < array.length - 2; i+=2) {
            TreeNode cur = queue.poll();
            TreeNode left = new TreeNode(array[i+1]);
            cur.left = left;
            queue.offer(left);
            System.out.print(left.key);

            TreeNode right = new TreeNode(array[i+2]);
            cur.right = right;
            queue.offer(right);
            System.out.print(right.key);

        }
        return root;
    }

    static public List<Integer> preOrder(TreeNode root) {
        List<Integer> keyList = new ArrayList();
        if (root == null) {
            return keyList;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            keyList.add(cur.key);
            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }
        }
        return keyList;
    }
// use a helper node to store the next "visiting" node and subtree
// 1. when helper node is not null, we should traverse the subtree, so we push heler and
//  we go left
// 2. when helper is null, means the left subtree of the root is finished, the root is the
//  top element in the stack. we can print the top and let helper = top.right(tranverse the
// left subtree first, then top, then right subtree)
// 3. do 1 and 2 until helper is null and there is no nodes left in the stack.
    static public List<Integer> inOrder(TreeNode root) {
        List<Integer> keyList = new ArrayList<>();
        if (root == null) {
            return keyList;
        }

        Deque<TreeNode> stack = new LinkedList();
        // we need to know the next node we would like to traverse
        TreeNode next = root;
        while (next != null || !stack.isEmpty()) {
            // traverse to the left until the leaf node
            if (next != null) {
                stack.offerFirst(next);
                next = next.left;
            } else {
                TreeNode cur = stack.pollFirst();
                keyList.add(cur.key);
                //finished left traversal, then the right
                next = cur.right;
            }
        }
        return keyList;
    }
    // left child, right child then root
    static public List<Integer> postOrder(TreeNode root) {
        List<Integer> keyList = new ArrayList();
        if (root == null) {
            return keyList;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        Deque<TreeNode> temp = new LinkedList<TreeNode>();
        stack.offerFirst(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            temp.offerFirst(cur);
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }
            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
        }

        while (!temp.isEmpty()) {
            keyList.add(temp.pollFirst().key);
        }

        return keyList;
    }

}









