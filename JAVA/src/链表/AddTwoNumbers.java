package 链表;

/*
 *@ClassName AddTwoNumbers 两数相加
 *@Author Freie  stellen
 *@Date 2024/4/25 15:54
 * 思路1：首先这是逆序储存的两个链表，所以要考虑到进1的问题，所以首先声明新链表的一个进位数，头节点以及头结点指针。遍历两个链表相加并且进位
 * 时间复杂度：o（m+n）m，n分别为两个链表的长度————————空间复杂度：o（1）返回值不计算
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode list1Node1 = new ListNode(2);
        ListNode list1Node2 = new ListNode(4);
        ListNode list1Node3 = new ListNode(3);

        list1Node1.next = list1Node2;
        list1Node2.next = list1Node3;

        ListNode list2Node1 = new ListNode(5);
        ListNode list2Node2 = new ListNode(6);
        ListNode list2Node3 = new ListNode(2);

        list2Node1.next = list2Node2;
        list2Node2.next = list2Node3;
        ListNode listNode = addTwoNumbers2(list1Node1, list2Node1);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
        System.out.println(listNode.next.next.next.val);
    }

    //迭代法
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        //声明头节点
        ListNode temp = new ListNode();

        //声明头节点指针
        ListNode pre = temp;

        //声明进位数
        int carry = 0;

        while (l1 != null || l2 != null) {

            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            //每个节点的总值l1节点值加上l2节点值再加上进位数值（只可能为1）
            int sum = x + y + carry;

            //得到进位数
            carry = sum / 10;

            //对总值取余拿到节点值
            sum %= 10;

            //创捷新的节点并建立连接
            pre.next = new ListNode(sum);

            //头节点指针指向下一个
            pre = pre.next;

            //l1和l2链表遍历
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            //如果进位数为1再建立一个新的节点
            if (carry == 1) {
                pre.next = new ListNode(carry);
            }
        }
        return temp.next;
    }
}
