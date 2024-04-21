package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 *@ClassName InorderTraversal 二叉树的中序遍历
 *@Author Freie  stellen
 *@Date 2024/4/19 16:37
 * 思路1：二叉树的中序遍历，递归思想（底层是栈，但虚拟机帮我们做了），首先无限递归根节点左子树，再加入根节点，再无限递归根节点的右子树
 * 时间复杂度o（n）————————空间复杂度o（n）开辟了辅助栈
 * 思路2：二叉树的中序遍历，迭代思想，和递归思想是一样的，只不过需要我们自己来操作进栈和出栈
 * 时间复杂度o（n）————————空间复杂度o（n）开辟了辅助栈
 * 思路3：莫里斯遍历，缺点是将树的结构变成了链表，优点是没有用辅助栈，空间复杂度为o（1）
 * 时间复杂度o（n）————————空间复杂度o（1）
 */
public class InorderTraversal {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode right1left2 = new TreeNode(3);
        TreeNode left1 = new TreeNode(5);
        TreeNode left1left2 = new TreeNode(6);
        TreeNode left1right2 = new TreeNode(7);

        root.right = right1;
        root.left = left1;
        left1.left = left1left2;
        left1.right = left1right2;
        right1.left = right1left2;

        for (Integer integer : inorderTraversal1(root)) {
            System.out.println(integer);
        }
        for (Integer integer : inorderTraversal2(root)) {
            System.out.println(integer);
        }
        for (Integer integer : inorderTraversal3(root)) {
            System.out.println(integer);
        }

    }

    //递归思想
    public static List<Integer> inorderTraversal1(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        visit(res, root);

        return res;
    }

    static void visit(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        visit(res, root.left);
        res.add(root.val);
        visit(res, root.right);
    }

    //迭代思想
    public static List<Integer> inorderTraversal2(TreeNode root) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (stack.size() > 0 || root != null) {

            if (root != null) {

                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                arrayList.add(pop.val);
                root = pop.right;
            }
        }
        return arrayList;
    }

    //莫里斯遍历
    public static List<Integer> inorderTraversal3(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        TreeNode pre;
        while (root != null) {
            //如果左节点不为空，就将当前节点连带右子树全部挂到
            //左节点的最右子树下面
            if (root.left != null) {
                pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root;
                //将root指向root的left
                TreeNode tmp = root;
                root = root.left;
                tmp.left = null;
                //左子树为空，则打印这个节点，并向右边遍历
            } else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
