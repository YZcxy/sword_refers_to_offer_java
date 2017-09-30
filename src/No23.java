import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//从上往下打印二叉树
public class No23 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (queue.peek()!=null){
            TreeNode temp = queue.poll();
            list.add(temp.val);
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }
        return list;
    }

}
