import java.util.Stack;

//包含Min函数的栈
public class No21 {
    Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack();
    int minNode = 2147483647;
    public void push(int node) {
        s1.push(node);
        if(node < minNode){
            s2.push(node);
            minNode = node;
        }else {
            s2.push(minNode);
        }
    }

    public void pop() {
        s1.pop();
        s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return minNode;
    }
}
