package 链表;

import java.util.Objects;

/*
 *@ClassName GetIntersectionNode 相交链表
 *@Author Freie  stellen
 *@Date 2024/4/2 16:43
 * 思路：相交链表的思路首先缩短两个链表之间的差距，同时开始遍历如果下一节点为null时则指向另一个链表的头节点，直到遍历结束。
 * 判断节点是否相同，相同则相交。不相同则不相交
 * 时间复杂度为o(n)，n为长链表的节点个数
 */
public class GetIntersectionNode {
    public static void main(String[] args) {
        ListNode list1Node1 = new ListNode(1);
        ListNode list1Node2 = new ListNode(2);
        ListNode list1Node3 = new ListNode(4);
        ListNode list1Node4 = new ListNode(6);
        ListNode list1Node5 = new ListNode(7);
        ListNode list1Node6 = new ListNode(9);
        ListNode list1Node7 = new ListNode(10);
        ListNode list1Node0 = new ListNode();

        list1Node0.next = list1Node1;
        list1Node1.next = list1Node2;
        list1Node2.next = list1Node3;
        list1Node3.next = list1Node4;
        list1Node4.next = list1Node5;
        list1Node5.next = list1Node6;
        list1Node6.next = list1Node7;

        ListNode list2Node1 = new ListNode(3);
        ListNode list2Node2 = new ListNode(5);

        ListNode list2Node0 = new ListNode();

        list2Node0.next = list2Node1;
        list2Node1.next = list2Node2;
        list2Node2.next = list1Node6;

        ListNode listNode = getIntersectionNode(list1Node0, list2Node0);
        if (!Objects.isNull(listNode)) {
            System.out.println(listNode.val);
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA.next == null || headB.next == null) {//判断链表的头节点下一节点是否为null
            return null;
        }
        ListNode A1 = headA.next;//指针A指向链表的第一个节点
        ListNode B1 = headB.next;//指针B指向链表的第一个节点

        while (A1 != B1) {
            A1 = A1 == null ? headB.next : A1.next;//缩减两个链表之间的差距，如果遍历完就指向另一个链表的头部开始遍历
            B1 = B1 == null ? headA.next : B1.next;//如果相交则会指向同一个节点
        }
        return A1;
    }
}

