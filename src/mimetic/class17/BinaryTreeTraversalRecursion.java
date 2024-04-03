package mimetic.class17;

/**
 * @ClassName BinaryTreeTraversalRecursion
 * @Description TODO
 * @Author zhengjiabin
 * @Date 2024/4/3 16:27
 * @Version 1.0
 **/
public class BinaryTreeTraversalRecursion {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }


    /**
     *
     * @author zhengjiabin
     * @description 前序遍历二叉树(中左右)。
     * 对于给定的二叉树，先访问根节点，然后递归地访问左子树，最后递归地访问右子树。
     * @date 2024/4/3 16:33
     * @param root 二叉树的根节点。如果根节点为null，则表示遍历空树。
     *
     **/
    public static void preOrder(TreeNode root){
        // 当遍历到空节点时，直接返回，结束递归
        if (root == null){
            return;
        }
        // 访问当前节点
        System.out.print(root.val + " ");
        // 递归地访问左子树
        preOrder(root.left);
        // 递归地访问右子树
        preOrder(root.right);
    }


    /**
     *
     * @author zhengjiabin
     * @description 中序遍历二叉树（左中右）。
     * 以中序遍历的方式打印二叉树的节点值，先遍历左子树，然后处理当前节点，最后遍历右子树。
     * @date 2024/4/3 16:40
     * @param head 二叉树的根节点
     *
     **/
    public static void inOrder(TreeNode head){
        // 当遍历到树的底部时，返回
        if (head == null){
            return;
        }
        // 遍历左子树
        inOrder(head.left);
        // 打印当前节点的值
        System.out.print(head.val + " ");
        // 遍历右子树
        inOrder(head.right);
    }


    /**
     *
     * @author zhengjiabin
     * @description 后序遍历二叉树（左右中）。
     * 以后序遍历的方式打印二叉树的节点值，先遍历左子树，然后遍历右子树，最后处理当前节点。
     * @date 2024/4/3 16:42
     * @param head 二叉树的根节点
     *
     **/
    public static void posOrder(TreeNode head){
        if (head == null){
            return;   // 如果当前节点为空，则返回，不进行任何操作
        }
        posOrder(head.left); // 先遍历左子树
        posOrder(head.right); // 再遍历右子树
        System.out.print(head.val + " "); // 最后打印当前节点的值
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        System.out.println("开始前序遍历:");
        preOrder(head);
        System.out.println();
        System.out.println("结束前序遍历:");

        System.out.println("开始中序遍历:");
        inOrder(head);
        System.out.println();
        System.out.println("结束中序遍历:");


        System.out.println("开始后序遍历:");
        posOrder(head);
        System.out.println();
        System.out.println("结束后序遍历:");

    }
}
