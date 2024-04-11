package 链表;

import java.util.HashSet;
import java.util.Set;

/*
 *@ClassName HasCycle 是否为环形链表
 *@Author Freie  stellen
 *@Date 2024/4/11 17:59
 * 思路1：龟兔赛跑（双指针）龟指针每次移动一个节点，兔指针每次移动两个节点。如果是相交节点则会遇到
 * 时间复杂度：o（n）n为链表的长度
 * 空间复杂度：只开辟了两个指针的空间
 * 思路2：hash表的使用set集合的唯一性，遍历链表并添加至hash表中，当遇到重复节点时返回true
 * 时间复杂度：o（n）n为链表的长度
 * 空间复杂度：开辟了hash表，最坏的情况要将每个节点都要添加至hash表
 */
public class HasCycle {
    public static void main(String[] args) {
        ListNode list1Node1 = new ListNode(1);
        ListNode list1Node2 = new ListNode(2);
        ListNode list1Node3 = new ListNode(4);
        ListNode list1Node4 = new ListNode(6);

        list1Node1.next = list1Node2;
        list1Node2.next = list1Node3;
        list1Node3.next = list1Node4;
        list1Node4.next = list1Node2;

        boolean hasCycle1 = hasCycle1(list1Node1);
        boolean hasCycle2 = hasCycle2(list1Node1);

        if (hasCycle1 && hasCycle2) {
            System.out.println("是环形链表");
            return;
        }
        System.out.println("不是环形链表");
    }

    public static boolean hasCycle1(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        //龟节点指向头节点
        ListNode slow = head;

        //兔节点指向龟节点的下一个
        ListNode fast = head.next;

        while (slow != fast) {

            if (fast == null || fast.next == null) {

                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static boolean hasCycle2(ListNode head) {

        Set<ListNode> listNodeSet = new HashSet<>();

        while (head != null) {
            //判断每次添加的结果
            if (!listNodeSet.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
