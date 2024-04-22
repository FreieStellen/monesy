package 二叉树;

import java.util.LinkedList;

/*
 *@ClassName InvertTree 翻转二叉树
 *@Author Freie  stellen
 *@Date 2024/4/21 21:11
 * 思路1：广度优先搜索：需要额外的队列空间，将每一层的节点加入队列中，然后每次取出一个交换左右孩子节点
 * 时间复杂度：o（n）——————空间复杂度：o（n）
 * 思路2：递归法：深度优先搜索：不需要额外的队列空间，底层栈由虚拟机。一杠子打到死之后在慢慢返回
 * 时间复杂度：o（n）——————空间复杂度：二叉树的高度o（h）
 */
public class InvertTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
//        TreeNode right1left2 = new TreeNode(5);
//        TreeNode right1right2 = new TreeNode(6);
        TreeNode left1 = new TreeNode(3);
//        TreeNode left1left2 = new TreeNode(7);
//        TreeNode left1right2 = new TreeNode(9);

        root.left = left1;
//        left1.left = left1left2;
//        left1.right = left1right2;

        root.right = right1;
//        right1.left = right1left2;
//        right1.right = right1right2;

        TreeNode treeNode1 = invertTree1(root);
        System.out.println(treeNode1.left.val);
        System.out.println(treeNode1.right.val);

        TreeNode treeNode2 = invertTree2(root);
        System.out.println(treeNode2.left.val);
        System.out.println(treeNode2.right.val);
    }

    //广度优先搜索：需要额外的队列空间，逐层遍历加入队列，将每个节点放进队列再取出交换左右孩子节点
    public static TreeNode invertTree1(TreeNode root) {

        if (root == null || (root.right == null && root.left == null)) {
            return root;
        }
        //开辟队列空间
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);

        //循环条件是直到队列空间为0
        while (list.size() > 0) {

            //取出队列头元素
            TreeNode treeNode = list.removeFirst();

            //交换节点的左右孩子
            TreeNode node = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = node;

            if (treeNode.left != null) {
                list.add(treeNode.left);
            }
            if (treeNode.right != null) {
                list.add(treeNode.right);
            }
        }
        return root;
    }

    //递归法
    public static TreeNode invertTree2(TreeNode root) {

        if (root == null || (root.right == null && root.left == null)) {
            return root;
        }

        TreeNode right = invertTree2(root.right);
        TreeNode left = invertTree2(root.left);

        root.right = left;
        root.left = right;
        return root;
    }
}
