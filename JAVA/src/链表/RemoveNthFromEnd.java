package 链表;

/*
 *@ClassName RemoveNthFromEnd 删除链表的倒数第N个结点
 *@Author Freie  stellen
 *@Date 2024/7/25 19:30
 * 思路：双指针思路，首先让前指针遍历所需要的n个节点，然后同时遍历两个指针，直到前指针遍历到最后一个节点。后指针指向的下一个就是所需要删除的节点
 * 时间复杂度：o（n）——————空间复杂度o（1）
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode listNode = removeNthFromEnd(listNode1, 1);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
        System.out.println(listNode.next.next.next.val);


    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }
        ListNode temp = head, res = temp;

        //前指针遍历n次
        for (int i = 0; i < n; i++) {
            res = res.next;
        }
        //双指针同时遍历，条件为前指针指向最后一个结点
        while (res.next != null) {
            res = res.next;
            temp = temp.next;
        }
        //此时后指针的next域即为删除节点
        temp.next = temp.next.next;
        return head;
    }
}
