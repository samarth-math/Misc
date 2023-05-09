package TreePractice;

import CustomDataStructures.AVLTreeNode;

import java.util.TreeMap;

public class AVLTree {

    AVLTreeNode head;
    AVLTreeNode currentHead;
    public AVLTreeNode AVLTree(int val) {
        head = new AVLTreeNode(val);
        head.height = 0;
        head.balanced = 0;
        currentHead = head;
        return head;
    }

    private int getBalance(AVLTreeNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }
    private int getHeight(AVLTreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private AVLTreeNode rightRotate(AVLTreeNode node) {
        AVLTreeNode x = node.left;
        AVLTreeNode y = x.right;

        x.right = node;
        node.left = y;

        node.height = Math.max(getHeight(node.left), getHeight(node.right))  + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right))  + 1;

        return x;
    }

    private AVLTreeNode leftRotate(AVLTreeNode node) {
        AVLTreeNode x = node.right;
        AVLTreeNode y = x.left;

        x.left = node;
        node.right = y;

        node.height = Math.max(getHeight(node.left), getHeight(node.right))  + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right))  + 1;

        return x;
    }

    private AVLTreeNode addNode(AVLTreeNode root, int value) {
        if (root == null) {
            return new AVLTreeNode(value);
        } else if (value< root.val) {
            root.left = addNode(root.left, value);
        } else if (value>root.val) {
            root.right = addNode(root.right, value);
        } else {
            return root;
        }
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        int balance = getBalance(root);
        //left right rotation
        if (balance > 1 && value > root.left.val) {
            leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance > 1 && value < root.left.val) {
            return rightRotate(root);
        }
        if (balance < -1 && value < root.left.val) {
            rightRotate(root.right);
            return leftRotate(root);
        }
        if (balance < -1 && value > root.left.val) {
            return leftRotate(root);
        }
        return root;
    }

    private AVLTreeNode minValueNode(AVLTreeNode node)
    {
        AVLTreeNode current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null)
            current = current.left;

        return current;
    }
    private AVLTreeNode deleteNode(AVLTreeNode root, int value) {
        if (root == null) {
            return root;
        }
        if (value < root.val) {
            root.left = deleteNode(root.left, value);
        }
        if (value > root.val) {
            root.right = deleteNode(root.right, value);
        }
        else {
            //one or no child
            if (root.left == null || root.right == null) {
                if (root.left == null && root.right == null) {
                    root = null;
                }
                if (root.left == null) {
                    root = root.right;
                }
                if (root.right == null) {
                    root = root.left;
                }
            }
            // 2 children
            else {
                AVLTreeNode temp = minValueNode(root.right);
                root.val = temp.val;
                root.right = deleteNode(root.right, temp.val);
            }
        }
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        int balance = getBalance(root);
        //left right rotation
        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    void preOrder(AVLTreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }



    public static void main(String[] args) {
        TreeMap<Integer, String> tm = new TreeMap<>();
    }
}
