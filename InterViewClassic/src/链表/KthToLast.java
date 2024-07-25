package 链表;

/*
 *@ClassName KthToLast 返回倒数第k个节点
 *@Author Freie  stellen
 *@Date 2024/7/25 16:28
 */
public class KthToLast {
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
        int kth = kthToLast(listNode1, 2);
        System.out.println(kth);
    }

    public static int kthToLast(ListNode head, int k) {

        if (head == null) {
            return 0;
        }
        ListNode temp = head, pre = temp.next;

        for (int i = 0; i < k; i++) {
            pre = pre.next;
        }

        while (pre != null) {
            temp = temp.next;
            pre = pre.next;
        }
        return temp.val;
    }
}
