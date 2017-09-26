//在O(1)时间删除链表节点
public class No13 {
    public void deleteNode(ListNode head,ListNode delNode){
        if(head==null||delNode==null)
            return;
        if(delNode.next!=null){
            ListNode temp = delNode.next;
            delNode.val = temp.val;
            delNode.next = temp.next;
        }else if(head == delNode){
            head = null;
        }else {
            ListNode temp = head;
            while (temp.next != delNode){
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }

    }

}

