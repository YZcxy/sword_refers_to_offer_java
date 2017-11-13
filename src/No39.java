//二叉树的深度
public class No39 {
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;

        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        return (left > right)? (left + 1) : (right + 1);
    }
}
