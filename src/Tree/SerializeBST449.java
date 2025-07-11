package Tree;

import java.util.*;

public class SerializeBST449 {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> stack = new LinkedList<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sb.append(node.val).append(",");

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        String[] values = data.split(",");
        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        stack.push(root);

        for (int i = 1; i < values.length; i++) {
            int val = Integer.parseInt(values[i]);
            TreeNode node = new TreeNode(val);

            TreeNode parent = stack.peek();
            if (val < parent.val) {
                parent.left = node;
            } else {
                while (!stack.isEmpty() && val > stack.peek().val) {
                    parent = stack.pop();
                }
                parent.right = node;
            }
            stack.push(node);
        }

        return root;
    }

}
