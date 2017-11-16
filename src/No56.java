import java.util.HashMap;

//链表中环的入口节点
public class No56 {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null) return null;
        HashMap<ListNode,String> map = new HashMap<>();
        while (pHead != null) {
            if (map.get(pHead) != null) {
                return pHead;
            }
            map.put(pHead,"1");
            pHead = pHead.next;
        }
        return null;
    }
}
