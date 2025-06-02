package Tree;


import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepth104 {
    public int maxDepth_r(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth_r(root.left), maxDepth_r(root.right)) + 1;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (currentNode != null) {
                    if (currentNode.left != null) {
                        queue.offer(currentNode.left);
                    }

                    if (currentNode.right != null) {
                        queue.offer(currentNode.right);
                    }
                }

            }
        }

        return depth;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
