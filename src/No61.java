import java.util.ArrayList;
import java.util.Stack;

//按之字形顺序打印二叉树
public class No61 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<Integer> row;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        leftStack.push(pRoot);
        while (leftStack.size() != 0 || rightStack.size() != 0) {
            if (leftStack.size() != 0) {
                row = new ArrayList<>();
                while (leftStack.size() != 0) {
                    if (leftStack.peek().left != null) {
                        rightStack.push(leftStack.peek().left);
                    }
                    if (leftStack.peek().right != null) {
                        rightStack.push(leftStack.peek().right);
                    }
                    row.add(leftStack.peek().val);
                    leftStack.pop();
                }
                result.add(row);
                continue;
            }
            if (rightStack.size() != 0) {
                row = new ArrayList<>();
                while (rightStack.size() != 0) {
                    if (rightStack.peek().right != null) {
                        leftStack.push(rightStack.peek().right);
                    }
                    if (rightStack.peek().left != null) {
                        leftStack.push(rightStack.peek().left);
                    }
                    row.add(rightStack.peek().val);
                    rightStack.pop();
                }
                result.add(row);
                continue;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        No61 n = new No61();
        n.Print(new TreeNode(1));
    }
}
