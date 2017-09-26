//合并两个排序的链表
public class No17 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null)return list2;
        if(list2==null)return list1;
        ListNode res = null;
        ListNode head = null;
        if(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                head = list1;
                res = list1;
                list1=list1.next;
            }else {
                head = list2;
                res = list2;
                list2=list2.next;
            }
        }
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                head.next = list1;
                head = head.next;
                list1 = list1.next;
            }else {
                head.next = list2;
                head = head.next;
                list2=list2.next;
            }
        }
        if(list1==null){
            while (list2!=null){
                head.next = list2;
                head = head.next;
                list2=list2.next;
            }
        }else {
            while (list1!=null){
                head.next = list1;
                head = head.next;
                list1=list1.next;
            }
        }
        return res;
    }
}
