//二叉树的镜像
public class No19 {
    public void Mirror(TreeNode root) {
        if(root==null)return;
        if(root.left==null&&root.right==null)return;
        TreeNode temp = null;
        temp = root.left;
        root.left = root.right;
        root.right = temp;

        Mirror(root.left);
        Mirror(root.right);

    }
}
