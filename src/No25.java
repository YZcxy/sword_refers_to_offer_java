import java.util.ArrayList;

//二叉树中和为某一值的路径
public class No25 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> intArray = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root != null) FindAllPath(root,target);
        return res;
    }

    public void FindAllPath(TreeNode root,int target){
        if(root == null) return;
        target -= root.val;
        intArray.add(root.val);

        if(target == 0&&root.left==null&&root.right==null){
            res.add(new ArrayList<Integer>(intArray));
        }else {
            FindAllPath(root.left,target);
            FindAllPath(root.right,target);
        }

        intArray.remove(intArray.size()-1);
    }
}
