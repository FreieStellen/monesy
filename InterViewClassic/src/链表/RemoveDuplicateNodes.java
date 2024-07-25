package 链表;

import java.util.HashSet;

/*
 *@ClassName RemoveDuplicateNodes 移除重复节点
 *@Author Freie  stellen
 *@Date 2024/7/23 19:08
 */
public class RemoveDuplicateNodes {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(1);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode = removeDuplicateNodes(listNode1);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);

    }

    public static ListNode removeDuplicateNodes(ListNode head) {

        if (head == null) {
            return null;
        }

        HashSet<Integer> set = new HashSet<>();
        ListNode temp = head;
        set.add(head.val);
        while (temp.next != null) {

            ListNode cur = temp.next;
            if (set.add(cur.val)) {
                temp = temp.next;
            } else {
                temp.next = temp.next.next;
            }
        }
        return head;
    }
}
