package CustomDataStructures;

public class AVLTreeNode {
    public int val;
    public AVLTreeNode left;
    public AVLTreeNode right;

    int height;
    int balanced;
    AVLTreeNode() {}
    public AVLTreeNode(int val) { this.val = val; }
    public AVLTreeNode(int val, AVLTreeNode left, AVLTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
