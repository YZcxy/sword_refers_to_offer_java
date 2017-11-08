import java.util.Stack;

//两个链表的第一个公结点
public class No37 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) return null;
        int index1 = myFun(pHead1,pHead2);
        int index2 = myFun(pHead2,pHead1);

        if (index1 > index2) {
            while (--index1 >= 0) {
                pHead1 = pHead1.next;
            }
            return pHead1;
        }else {
            while (--index2 >= 0) {
                pHead2 = pHead2.next;
            }
            return pHead2;
        }
    }

    public int myFun(ListNode pHead1, ListNode pHead2){
        int index = 0;
        ListNode curr1 = pHead1;
        ListNode curr2;
        boolean hasCommon = false;
        while (curr1 != null) {
            curr2 = pHead2;
            while (curr2 != null) {
                if(curr1.val == curr2.val){
                    hasCommon = true;
                    break;
                }
                curr2 = curr2.next;
            }
            if (hasCommon) {
                break;
            }
            index++;
            curr1 = curr1.next;
        }

        return index;
    }

    //解法2
    public ListNode FindFirstCommonNodd2(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) return null;
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while (pHead1 != null) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }

        ListNode resNode = null;
        while (stack1 != null && stack2 != null && stack1.peek() == stack2.peek()) {
            resNode = stack1.peek();
            stack1.pop();
            stack2.pop();
        }
        return resNode;
    }
}
