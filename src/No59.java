import java.util.ArrayList;
import java.util.List;

//对称的二叉树
public class No59 {
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        leftChild(pRoot.left,leftList);
        rightChild(pRoot.right,rightList);
        if (leftList.size() != rightList.size()) return false;
        for (int i = 0;i < leftList.size();i++) {
            if (leftList.get(i) != rightList.get(i)) {
                return false;
            }
        }

        return true;
    }
    private void leftChild(TreeNode root,List<Integer> result) {
        if (root == null) {
            result.add(-1);
            return;
        }
        result.add(root.val);
        leftChild(root.left,result);
        leftChild(root.right,result);
    }
    private void rightChild(TreeNode root,List<Integer> result) {
        if (root == null) {
            result.add(-1);
            return;
        }
        result.add(root.val);
        rightChild(root.right,result);
        rightChild(root.left,result);
    }
}
