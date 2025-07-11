package Tree;

public class SearchInBST700 {
    public TreeNode searchBST_i(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }

    public TreeNode searchBST_r(TreeNode root, int val) {
        return (root == null || root.val == val)
                ? root
                : val < root.val ? searchBST_r(root.left, val) : searchBST_r(root.right, val);

    }
}


