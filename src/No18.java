//树的子结构
public class No18 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        boolean res=false;
        if(root1!=null && root2!=null){
            if(root1.val == root2.val){
                res = doSub(root1,root2);
            }
            if(!res){
                res = HasSubtree(root1.left,root2);
            }
            if(!res){
                res = HasSubtree(root1.right,root2);
            }
        }
        return res;
    }

    public boolean doSub(TreeNode root1,TreeNode root2){
        if(root2 == null)
            return true;
        if(root1 == null)
            return false;
        if(root1.val != root2.val)
            return false;

        return doSub(root1.left,root2.left) && doSub(root1.right,root2.right);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
