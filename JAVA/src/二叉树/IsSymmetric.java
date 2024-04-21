package 二叉树;

import java.util.LinkedList;

/*
 *@ClassName IsSymmetric 对称二叉树
 *@Author Freie  stellen
 *@Date 2024/4/21 15:28
 * 思路1：队列法，运用队列先进先出的性质，每次比较队列的前两个节点，成功后再加入子节点的左右孩子节点，每次加入四个节点。最后利用continue语句将空节点全部跳过
 * 时间复杂度：o（n）————————空间复杂度：o（n）
 * 思路2：递归法，和二叉树的遍历递归性质一样
 * 时间复杂度：o（n）————————空间复杂度：o（n）
 */
public class IsSymmetric {

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

        boolean symmetric2 = isSymmetric2(root);
        boolean symmetric1 = isSymmetric1(root);
        if (symmetric1 && symmetric2) {
            System.out.println("是对称二叉树");
        }
    }

    //队列法
    public static boolean isSymmetric1(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        //用队列保存节点,用LinkedList队列时，插入空数据不会报错
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        //将根节点的左右孩子放到队列中
        queue.add(root.left);
        queue.add(root.right);
        while (queue.size() > 0) {
            //将前两个队列节点拿出来比较
            TreeNode first = queue.removeFirst();
            TreeNode second = queue.removeFirst();
            if (first == null && second == null) {
                continue;
            }
            if (first == null || second == null) {
                return false;
            }
            if (first.val != second.val) {
                return false;
            }
            //分别添加子节点
            queue.add(first.left);
            queue.add(second.right);

            queue.add(first.right);
            queue.add(second.left);
        }

        return true;

    }

    //递归法
    public static boolean isSymmetric2(TreeNode root) {

        if (root == null) {
            return true;
        }
        return visit(root.right, root.left);
    }

    static boolean visit(TreeNode right, TreeNode left) {

        //如果左右孩子同时为null则返回true
        if (right == null && left == null) {
            return true;
        }
        if (right == null || left == null) {
            return false;
        }
        if (right.val != left.val) {
            return false;
        }
        return (visit(right.right, left.left) && visit(right.left, left.right));
    }
}
