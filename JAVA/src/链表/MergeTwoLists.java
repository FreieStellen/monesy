package 链表;

/**
 * @param: 合并两个有序链表
 * @date: 2024/3/20 16:42
 * 思路：同时迭代对比两个链表并按照大小进行排序合成新的链表
 * 时间复杂度为O(m+n)m为链表1的长度，n为链表2的长度
 */

public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode list1Node1 = new ListNode(1);
        ListNode list1Node2 = new ListNode(2);
        ListNode list1Node3 = new ListNode(4);
        ListNode list2Node1 = new ListNode(1);
        ListNode list2Node2 = new ListNode(3);
        ListNode list2Node3 = new ListNode(4);
        ListNode list2Node4 = new ListNode(5);
        list1Node1.next = list1Node2;
        list1Node2.next = list1Node3;

        list2Node1.next = list2Node2;
        list2Node2.next = list2Node3;
        list2Node3.next = list2Node4;

        mergeTwoLists(list1Node1, list2Node1);
    }

    public static void mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dum = new ListNode(0), cur = dum;//定义新链表的头节点并用指针指代
        while (list1 != null && list2 != null) {//循环判断条件为当两个链表都不为空时跳出循环
            if (list1.val < list2.val) {//迭代对比链表数据并成为新链表的节点
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;//此时有可能出现l1或者l2为空的情况发生，用三目运算符判断
    }
}
