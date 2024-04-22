package 二叉树;

import java.util.LinkedList;

/*
 *@ClassName MergeTrees 合并二叉树
 *@Author Freie  stellen
 *@Date 2024/4/22 11:21
 * 思路1：将一棵树合并到另一颗树上，利用队列，当对应位置同时存在时将两个对应节点添加到队列中并且每次取两个出来进行操作和判断。我们只需要注意主树的节点左右子树是否存在
 * 如果和辅树对应的节点同时存在就加入队列，如果主树左右子树不存在就将辅树对应节点的左右子树挂到主树上的对应节点
 * 时间复杂度：o（n）————————空间复杂度：o（n）
 * 思路2：递归法，创建一颗新树，将两棵树合并到一棵树上
 * 时间复杂度：o（n）————————空间复杂度：O(min(m,n))递归调用的所需要的层数不会超过较小树的高度
 */
public class MergeTrees {
    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode leftleft1 = new TreeNode(5);
        TreeNode leftright1 = new TreeNode(7);

        root1.left = left;
        left.left = leftleft1;
        left.right = leftright1;

        TreeNode root2 = new TreeNode(4);
        TreeNode right1 = new TreeNode(8);
        TreeNode left1 = new TreeNode(8);
        TreeNode left1left1 = new TreeNode(3);

        root2.right = right1;
        root2.left = left1;
        left1.left = left1left1;

        TreeNode treeNode1 = mergeTrees1(root1, root2);
        System.out.println(treeNode1.right.val);
        System.out.println(treeNode1.left.val);

        TreeNode treeNode2 = mergeTrees2(root1, root2);
        System.out.println(treeNode2.right.val);
        System.out.println(treeNode2.left.val);
    }

    //迭代法
    public static TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();

        linkedList.add(root1);
        linkedList.add(root2);

        while (linkedList.size() > 0) {

            TreeNode node1 = linkedList.removeFirst();
            TreeNode node2 = linkedList.removeFirst();

            node1.val += node2.val;

            if (node1.left != null && node2.left != null) {
                linkedList.add(node1.left);
                linkedList.add(node2.left);
            } else if (node1.left == null) {
                node1.left = node2.left;
            }
            if (node1.right != null && node2.right != null) {
                linkedList.add(node1.right);
                linkedList.add(node2.right);
            } else if (node1.right == null) {
                node1.right = node2.right;
            }
        }
        return root1;
    }

    //递归法
    public static TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees2(root1.left, root2.left);
        root.right = mergeTrees2(root1.right, root2.right);

        return root;
    }
}
