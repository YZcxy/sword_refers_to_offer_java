//复杂链表的复制
public class No26 {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null)return null;

        RandomListNode currNode = pHead;
        //复制每个节点，并接在复制节点的后面。A->B->C变为A->a->B->b->C->c
        while (currNode!=null){
            RandomListNode temp = new RandomListNode(currNode.label);
            temp.next = currNode.next;
            currNode.next = temp;
            currNode = temp.next;
        }
        currNode = pHead;
        //复制每个节点的随机指针
        while (currNode!=null){
            if(currNode.random !=null){
                currNode.next.random = currNode.random.next;
            }
            currNode = currNode.next.next;
        }
        //拆分为两个链表
        RandomListNode res = pHead.next;
        RandomListNode currRes = res;
        currNode = pHead;
        while (currNode!=null){
            currNode.next = currNode.next.next;
            if(currRes.next!=null){
                currRes.next = currRes.next.next;
            }
            currNode = currNode.next;
            currRes = currRes.next;
        }
        return res;
    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
