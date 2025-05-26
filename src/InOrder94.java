import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder94 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal_i(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val); 
            current = current.right;
        }
        
        return result;
    }

        public List<Integer> inorderTraversal_r(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root != null) {
            result.addAll(inorderTraversal_r(root.left));
            result.add(root.val);
            result.addAll(inorderTraversal_r(root.right));
        }
        
        return result;
    }
}
