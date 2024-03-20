package 链表;
/**
 *
 * @param: 链表的反转
 * @date: 2024/3/20 10:33
 */

public class ReverseListNode {
    public static void main(String[] args) {
        ListNode list1Node1 = new ListNode(1);
        ListNode list1Node2 = new ListNode(2);
        ListNode list1Node3 = new ListNode(4);
        ListNode list1Node0 = new ListNode();//表头不存放数据，next指向链表的第一个元素

        list1Node0.next = list1Node1;
        list1Node1.next = list1Node2;
        list1Node2.next = list1Node3;

        reverseList(list1Node0);
    }

    public static void reverseList(ListNode head) {
        if (head.next == null) {//判断链表头的下一个元素是否为null，如果是则直接返回
            return;
        }

        ListNode listNode = head.next;//头节点不能动所以使用第一个新指针来指代头节点的下一位
        ListNode temp = null;//定义一个新的链表
        ListNode next;//使用第二个新指针来指代head.next的下一位

        while (listNode != null) {//循环判断
            next = listNode.next;//next指针指向原链表头结点的下一位的下一位
            listNode.next = temp;//头结点的下一位的next域指向新链表的头节点下一位null
            temp = listNode;//temp成为新链表的头节点
            listNode = next;//原链表的头节点指向next指针
        }
        System.out.println(temp);
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val + "}";
    }
}