import java.util.Stack;

//栈的压入、弹出序列
public class No22 {
    Stack<Integer> s1 = new Stack();
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length ==0 || popA.length ==0)return false;
        if(pushA.length != popA.length) return false;

        for(int i=0,j=0;i<pushA.length;i++){
            s1.push(pushA[i]);
            while (j<popA.length && s1.peek().equals(popA[j])){
                s1.pop();
                j++;
            }
        }
        return  s1.empty();
    }
}

