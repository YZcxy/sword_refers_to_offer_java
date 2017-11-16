import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//删除链表中重复的节点
public class No57 {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;

        HashMap<Integer,String> map = new HashMap<>();
        HashMap<Integer,String> dupMap = new HashMap<>();
        ListNode current = pHead;
        while (current != null) {
            if (map.get(current.val) != null) {
                dupMap.put(current.val,"1");
            }
            map.put(current.val,"1");
            current = current.next;
        }
        current = pHead;
        ListNode pre = pHead;
        while (current != null) {
            if (dupMap.get(current.val) != null) {
                if (current == pHead) {
                    if (current.next == null) {
                        return null;
                    }
                    pHead = current.next;
                    current = current.next;
                    pre = current.next;
                    continue;
                }
                if (current.next != null) {
                    pre.next = current.next;
                    current = current.next;
                    continue;
                }
                if (current.next == null) {
                    pre.next = null;
                    continue;
                }
            }
            pre = current;
            current = current.next;
        }
        return pHead;
    }
}
