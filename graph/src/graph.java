import apple.laf.JRSUIUtils;

import java.util.Deque;
import java.util.*;
import java.util.function.BiFunction;

/**
 * Created by apple on 10/05/2017.
 */

class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int key;
    TreeNode(int key){
        this.key = key;
        this.left = null;
        this.right = null;
    }
}
public class graph {
    public static void main(String[] Arg) {
        TreeNode root = new TreeNode(0);
        generate(root);
        BFSPrint(root);
    }

    public static void generate(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        q.offerFirst(root);
        int count = 1;
        while (count <= 100) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = q.pollLast();
                n.left = new TreeNode(count++);
                q.offerFirst(n.left);
                n.right = new TreeNode(count++);
                q.offerFirst(n.right);
            }
        }
        return;
    }
    public static void BFSPrint(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);

        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = stack.pollLast();
                if (n.left != null) {
                    stack.offerFirst(n.left);
                }

                if (n.right != null) {
                    stack.offerFirst(n.right);
                }

                System.out.print(n.key + " ");
            }
            System.out.println();
        }
    }
}
