//二叉搜索树与双向链表
public class No27 {
    TreeNode lastNode;
    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertNode(pRootOfTree);

        TreeNode headNode = lastNode;
        while (headNode!=null && headNode.left!=null){
            headNode = headNode.left;
        }
        return headNode;
    }

    public void ConvertNode(TreeNode pNode){
        if(pNode == null)return;

        if(pNode.left!=null){
            ConvertNode(pNode.left);
        }

        pNode.left = lastNode;
        if(lastNode!=null){
            lastNode.right = pNode;
        }
        lastNode = pNode;

        if(pNode.right!=null){
            ConvertNode(pNode.right);
        }
    }
}
