package TreePractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree2 {

    List lArray = new ArrayList<Integer>();
    List rArray = new ArrayList<Integer>();
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        inOrderTraversal(root, lArray);
        inOrderTraversal(root, rArray);
        if(lArray.size()!=rArray.size()) {
            return false;
        }
        int i=0;
        int j=rArray.size()-1;
        while(i<lArray.size() && j>=0) {
            if(lArray.get(i)!=rArray.get(j)) {
                return false;
            } else {
                i++; j--;
            }
        }
        return true;
    }

    private void inOrderTraversal(TreeNode root, List result) {
        if(root == null) {
            result.add(null);
        }
        if (root.left==null && root.right==null) {
            result.add(root);
            return;
        }
        inOrderTraversal(root.left, result);
        result.add(root);
        inOrderTraversal(root.right, result);
        return;

    }

}
