/**
* 【从尾到头打印链表】
* 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
*/
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
