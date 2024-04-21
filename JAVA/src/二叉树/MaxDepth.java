package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/*
 *@ClassName MaxDepth 二叉树的最大深度
 *@Author Freie  stellen
 *@Date 2024/4/21 17:23
 * 思路1：二叉树的遍历，将问题分为求解每一个左子树和右子树最大的深度再加上根节点1
 * 时间复杂度：o（n）——————空间复杂度：底层是递归遍历栈，取决于栈空间的创建，o（n）n代表树的高度
 * 思路2：广度优先搜索，将一层所有的节点全部放进队列，每次拿出一层中的一个队列节点时将个数减一，当个数减为0时到外层循环，
 * 此时已经将下一层的节点全部加入队列了在进入内层循环
 * 时间复杂度：o（n）——————空间复杂度：o（n）
 */
public class MaxDepth {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode right1left2 = new TreeNode(6);
        TreeNode right1right2 = new TreeNode(7);
        TreeNode left1 = new TreeNode(2);
        TreeNode left1left2 = new TreeNode(7);
        TreeNode left1right2 = new TreeNode(6);

        root.left = left1;
        left1.left = left1left2;
        left1.right = left1right2;

        root.right = right1;
        right1.left = right1left2;
        right1.right = right1right2;

        int maxDepth1 = maxDepth1(root);
        int maxDepth2 = maxDepth2(root);
        System.out.println(maxDepth1);
        System.out.println(maxDepth2);
    }

    //解法一：递归。二叉树递归遍历，将问题分解为左右子树的最大深度
    public static int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int rightDepth = maxDepth1(root.right);
            int leftDepth = maxDepth1(root.left);

            return Math.max(rightDepth, leftDepth) + 1;
        }
    }

    //解法二：广度优先搜索
    public static int maxDepth2(TreeNode root) {

        if (root == null) {
            return 0;
        }
        //定义一个队列用于装每一层的节点
        Queue<TreeNode> list = new LinkedList<>();

        //用于记录拓展的次数，每次将队列的节点清空时计数加一
        int count = 0;

        //将树的根节点先加入队列
        list.offer(root);

        while (!list.isEmpty()) {
            //显示每一层加入队列节点的个数
            int size = list.size();
            while (size > 0) {
                //每次拿出一层中的一个队列节点时将个数减一，当个数减为0时到外层循环，此时已经将下一层的节点全部加入队列了在进入内层循环
                TreeNode treeNode = list.poll();
                if (treeNode.left != null) {
                    list.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    list.add(treeNode.right);
                }
                size--;
            }
            count++;
        }

        return count;
    }
}
