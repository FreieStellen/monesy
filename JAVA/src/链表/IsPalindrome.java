package 链表;

import java.util.ArrayList;
import java.util.Objects;

/*
 *@ClassName IsPalindrome 回文链表
 *@Author Freie  stellen
 *@Date 2024/4/16 21:50
 * 思路：将链表的所有节点转为一个数组，然后利用双指针前后开始遍历对比
 * 时间复杂度：遍历链表o（n）+双指针遍历数组o（n/2）=o（2n）=o（n）
 * 空间复杂度：开辟了o（n）大小的数组
 */
public class IsPalindrome {
    public static void main(String[] args) {
        ListNode list1Node1 = new ListNode(1);
        ListNode list1Node2 = new ListNode(2);
        ListNode list1Node3 = new ListNode(2);
        ListNode list1Node4 = new ListNode(1);
        ListNode list1Node0 = new ListNode(0);


        list1Node1.next = list1Node2;
        list1Node2.next = list1Node3;
        list1Node3.next = list1Node4;
        list1Node0.next = list1Node1;

        boolean palindrome = isPalindrome(list1Node0);

        System.out.println(palindrome);

    }


    public static boolean isPalindrome(ListNode head) {

        if (head.next == null) {
            return false;
        }
        ArrayList<Integer> valArry = new ArrayList<>();

        ListNode var = head.next;

        //将链表每个节点的值加入数组
        while (var != null) {
            valArry.add(var.val);
            var = var.next;
        }

        int brfore = 0;
        int front = valArry.size() - 1;

        //双指针前后遍历对比
        for (int i = 0; i < valArry.size() / 2; i++) {
            if (!Objects.equals(valArry.get(brfore), valArry.get(front))) {
                return false;
            }
            valArry.get(brfore++);
            valArry.get(front--);
        }
        return true;
    }
}
