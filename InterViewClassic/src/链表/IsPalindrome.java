package 链表;

/*
 *@ClassName IsPalindrome 回文链表
 *@Author Freie  stellen
 *@Date 2024/7/25 17:36
 */
public class IsPalindrome {
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

        boolean flag = isPalindrome(listNode1);
        System.out.println(flag);
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode temp = head, cur = temp, res = head;
        int num = 0;
        while (temp != null) {
            temp = temp.next;
            num++;
        }

        for (int i = 0; i < num / 2; i++) {
            cur = cur.next;
        }
        int number = num / 2;
        for (int i = 0; i < num / 2; i++) {

            int half = firstHalf(res, number);

            if (half != cur.val) {
                return false;
            }
            cur = cur.next;
            number -= 1;
        }
        return true;
    }

    public static int firstHalf(ListNode head, int num) {

        while (num - 1 > 0) {
            num -= 1;
            head = head.next;
        }
        return head.val;
    }
}
