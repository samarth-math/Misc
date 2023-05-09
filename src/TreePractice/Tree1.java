package TreePractice;

import CustomDataStructures.CustomTuple;

import java.util.*;

public class Tree1 {

    public static void main(String[] args) {
        Stack stack = new Stack();
    }

    public void Tree1() {}

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList();
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        Map<TreeNode, CustomTuple> sumMap = new HashMap<TreeNode, CustomTuple>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        stack.push(current);
        sumMap.put(current, new CustomTuple(current.val, new ArrayList(Arrays.asList(current.val))));
        while(!stack.empty()) {
            current = stack.pop();
            System.out.println("current: "+current.val);
            int currSum = sumMap.get(current).leftVal;
            System.out.println("cSum: " + currSum);
            if (current.right!=null) {
                if(currSum + current.right.val <= targetSum) {
                    stack.push(current.right);
                    List currentPath = new ArrayList(sumMap.get(current).rightVal);
                    currentPath.add(current.right.val);
                    System.out.println("cPath: " + currentPath);
                    sumMap.put(current.right, new CustomTuple(currSum + current.right.val, currentPath));
                }
            }
            if (current.left!=null) {
                if (currSum + current.left.val <= targetSum) {
                    stack.push(current.left);
                    List currentPath = new ArrayList(sumMap.get(current).rightVal);
                    currentPath.add(current.left.val);
                    System.out.println("cPath: " + currentPath);
                    sumMap.put(current.left, new CustomTuple(currSum + current.left.val, currentPath));
                }
            }
            if (current.left == null && current.right == null) {
                System.out.println("leaf:" + sumMap.get(current).leftVal);
                if (sumMap.get(current).leftVal == targetSum) {
                    result.add(sumMap.get(current).rightVal);
                }
            }
        }
        return result;
    }
}
