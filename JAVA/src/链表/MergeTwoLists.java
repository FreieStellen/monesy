package 链表;

public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode list1Node1 = new ListNode(1);
        ListNode list1Node2 = new ListNode(2);
        ListNode list1Node3 = new ListNode(4);
        ListNode list2Node1 = new ListNode(1);
        ListNode list2Node2 = new ListNode(3);
        ListNode list2Node3 = new ListNode(4);
        list1Node1.next = list1Node2;
        list1Node2.next = list1Node3;

        list2Node1.next = list2Node2;
        list2Node2.next = list2Node3;

        mergeTwoLists(list1Node1, list2Node1);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        if (list1 == null)
//            return list1;
//        if (list2 == null)
//            return list2;
//        ListNode curr = new ListNode(-1);
//        ListNode dum = curr;
//        while (list1 != null && list2 != null) {
//            if (list1.val <= list2.val) {
//                dum.next = list1;
//                list1 = list1.next;
//            } else {
//                dum.next = list2;
//                list2 = list2.next;
//            }
//            dum = dum.next;
//            System.out.println(dum);
//        }
//        curr.next = list1 != null ? list1 : list2;
//        System.out.println(dum);
//        return dum;
        ListNode dum = new ListNode(0), cur = dum;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;
        return dum.next;

    }
}
