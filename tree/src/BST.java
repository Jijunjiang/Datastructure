/**
 * Created by apple on 18/06/2017.
 */
public class BST {
    public TreeNode search(TreeNode root, int target) {
        TreeNode currentNode = root;
        while (currentNode != null && currentNode.key != target) {
            if (target < currentNode.key) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }

        // exit while loop: currentNode = null or currentNode.key == target
        return currentNode;
    }

    public TreeNode insert(TreeNode root, int target) {
        TreeNode newNode = new TreeNode(target);
        if (root == null) {
            return newNode;
        }
        TreeNode current = root;
        // if target < node.value, left else right
        while (current.key != target) {
            if (current.key > target) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = newNode;
                    break;
                }
            } else {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = newNode;
                }
            }
        }
        return root;
    }

    //iterative insert
    public TreeNode inserti(TreeNode root, int target) {
        if (root == null) {
            root = new TreeNode(target);
            return root;
        }

        if (target < root.key) {
            root.left = inserti(root.left, target);
        } else {
            root.right = inserti(root.right, target);
        }
        return root;
    }

    // delete: find the smallest node of nodes in the target's right
    // the largest node of nodes in target's left, move it up

    public TreeNode delete(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (target < root.key) {
            root.left = delete(root.left, target);
            return root;
        } else if (target > root.key) {
            root.right = delete(root.right, target);
            return root;
        }

        // now target == root.key
        if (root.right == null) {
            return root.left;
        }
        if (root.left == null) {
            return root.right;
        }

        // if target's right, we need the smallest, if target's right's left is
        // null then target's right is the smallest
        if (root.right.left == null) {
            root.right.left = root.left;
            return root.right;
        }

        //find the smallest node
        TreeNode smallest = deleteSmallest(root.right);
        smallest.left = root.left;
        smallest.right = root.right;
        return smallest;
    }

    private TreeNode deleteSmallest(TreeNode cur) {

        if (cur.left == null) {
            return cur;
        }
        TreeNode prev = cur;
        cur = cur.left;
        while (cur.left != null) {
            prev = cur;
            cur = cur.left;
        }
        // cur is the smallest node and should be deleted and pre is its parent
        prev.left = cur.right;
        return cur;
    }



}





























