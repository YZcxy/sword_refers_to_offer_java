//二叉搜索树的第k个结点
public class No63 {
    int num=0;
    public TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) return null;
        num = k;
        return preTraverse(pRoot);
    }

    private TreeNode preTraverse(TreeNode pRoot){
        if (pRoot == null) {
            return null;
        }

        TreeNode result = preTraverse(pRoot.left);
        if(result == null && --num == 0) {
            result = pRoot;
        }
        if (result == null) {
            result = preTraverse(pRoot.right);
        }
        return result;
    }
}
