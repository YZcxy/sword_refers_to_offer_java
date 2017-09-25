//链表中倒数第K个节点
public class No15 {
    int k = 0;
    ListNode res = null;
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null)
            return null;
        this.k = k;
        FindHandler(head);
        return res;
    }
    public void FindHandler(ListNode head){
        if(head == null)return;
        FindHandler(head.next);
        if(--k==0){
            res = head;
        }
    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int val){this.val = val;}
    }
}
