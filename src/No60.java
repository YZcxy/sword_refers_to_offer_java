import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//把二叉树打印成多行
public class No60 {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<Integer> row ;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;
        Queue<TreeNode> jQueue = new LinkedList<>();
        Queue<TreeNode> lQueue = new LinkedList<>();
        jQueue.add(pRoot);
        while (jQueue.peek() != null || lQueue.peek() != null) {
            if (jQueue.peek() != null) {
                row = new ArrayList<>();
                while (jQueue.peek() != null) {
                    if (jQueue.peek().left != null) {
                        lQueue.add(jQueue.peek().left);
                    }
                    if (jQueue.peek().right != null) {
                        lQueue.add(jQueue.peek().right);
                    }
                    row.add(jQueue.peek().val);
                    jQueue.poll();
                }
                result.add(row);
                continue;
            }
            if (lQueue.peek() != null) {
                row = new ArrayList<>();
                while (lQueue.peek() != null) {
                    if (lQueue.peek().left != null) {
                        jQueue.add(lQueue.peek().left);
                    }
                    if (lQueue.peek().right != null) {
                        jQueue.add(lQueue.peek().right);
                    }
                    row.add(lQueue.peek().val);
                    lQueue.poll();
                }
                result.add(row);
                continue;
            }
        }
        return result;
    }
}
