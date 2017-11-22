//二叉树的下一个结点
public class No58 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode result = null;
        if (pNode == null) return result;
        if (pNode.right != null) {
            TreeLinkNode current = pNode.right;
            while (current.left != null) {
                current = current.left;
            }
            return current;
        } else {
            TreeLinkNode current = pNode;
            while (current.next != null) {
                if (current.next.left == current) {
                    return current.next;
                } else {
                    current = current.next;
                }
            }
            return null;
        }
    }
}
