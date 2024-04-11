package 链表;

/*
 *@ClassName RemoveElements 移除链表指定元素
 *@Author Freie  stellen
 *@Date 2024/4/11 17:01
 * 思路1：递归调用（从头向后调用）逐步排查和目标值相等的节点值，如果有则让前一节点的next域指向与目标值相等的节点的下一节点
 * 思路2：从头结点的下一节点逐步排查和目标值相等的节点值，如果有则让前一节点的next域指向与目标值相等的节点的下一节点
 * 时间复杂度：o（n）n为链表的长度
 */
public class RemoveElements {
    public static void main(String[] args) {
        ListNode list1Node0 = new ListNode();
        ListNode list1Node1 = new ListNode(1);
        ListNode list1Node2 = new ListNode(2);
        ListNode list1Node3 = new ListNode(4);
        ListNode list1Node4 = new ListNode(6);
        ListNode list1Node5 = new ListNode(7);
        ListNode list1Node6 = new ListNode(8);
        ListNode list1Node7 = new ListNode(6);

        list1Node0.next = list1Node1;
        list1Node1.next = list1Node2;
        list1Node2.next = list1Node3;
        list1Node3.next = list1Node4;
        list1Node4.next = list1Node5;
        list1Node5.next = list1Node6;
        list1Node6.next = list1Node7;

        removeElements1(list1Node0, 6);
        removeElements2(list1Node0, 6);
    }

    /**
     * @Description: 链表的定义具有递归的性质，具有不连续的存储空间
     * @param: head val
     * @date: 2024/4/11 17:14
     */

    public static void removeElements1(ListNode head, int val) {
        if (head == null) {
            return;
        }
        removeElements1(head.next, val);
        System.out.println(head.val == val ? head.next : head);
    }

    /**
     * @Description: 从头节点的下一节点开始从前向后遍历，使用双指针方式遍历
     * @param: head val
     * @date: 2024/4/11 17:17
     */

    public static void removeElements2(ListNode head, int val) {

        //指定头节点指向指针
        ListNode cur = head;

        //指定头节点的对比指针
        ListNode next = head.next;
        while (next != null) {
            //如果对比指针和目标值相同则让指向指针的节点的next域指向对比指针的下一个节点，但指向指针指向不变
            if (next.val == val) {
                cur.next = next.next;
            } else {
                //反之，指向指针指向对比指针的节点
                cur = next;
            }
            //对比指针指向下一个
            next = next.next;
            System.out.println(cur);
        }

    }
}

