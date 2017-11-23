import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//序列化二叉树
public class No62 {
    public String Serialize(TreeNode root) {
        if (root == null) return null;
        StringBuffer sb = new StringBuffer();
        preTraverse(root,sb);
        return sb.toString();
    }
    public TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) return null;
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0;i < str.length();i++) {
            queue.add(str.charAt(i));
        }
        TreeNode root = new TreeNode(0);
        posTraverse(root,queue);
        return root;
    }

    private void preTraverse(TreeNode root,StringBuffer sb){
        if (root == null) {
            sb.append('$');
            return;
        }
        sb.append(root.val);
        preTraverse(root.left,sb);
        preTraverse(root.right,sb);
    }


    private String posTraverse(TreeNode root,Queue<Character> queue){
        if (queue.peek() != '$') {
            root.val = queue.peek()-'0';
            root.left = new TreeNode(0);
            root.right = new TreeNode(0);
            queue.poll();
            if(posTraverse(root.left,queue) == null) {
                root.left = null;
            }
            if(posTraverse(root.right,queue) == null) {
                root.right = null;
            }
            return "1";
        } else {
            queue.poll();
            return null;
        }
    }

    public static void main(String[] args) {
        No62 n = new No62();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        n1.left = n2;
        n1.right = n3;
        n.Serialize(n1);
        n.Deserialize("124$$$35$$6$$");

    }
}
