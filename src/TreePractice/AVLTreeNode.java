package TreePractice;

public class AVLTreeNode {
    int val;
    AVLTreeNode left;
    AVLTreeNode right;

    int height;
    int balanced;
    AVLTreeNode() {}
    AVLTreeNode(int val) { this.val = val; }
    AVLTreeNode(int val, AVLTreeNode left, AVLTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
