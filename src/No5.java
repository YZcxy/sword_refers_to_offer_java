//打印链表
import java.util.ArrayList;
public class No5 {
    ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode != null){
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}
