package github.grapeqin.binarytree;

/**
 * 平衡二叉树
 */
public class LeetCode110 {

    /**
     * 判断一棵二叉树是否平衡二叉树
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }
        int left = height(root.getLeft());
        int right = height(root.getRight());
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return isBalanced(root.getLeft()) && isBalanced(root.getRight());
    }

    /**
     * 求二叉树的高度
     * @param node
     * @return
     */
    public int height(TreeNode node) {
        if (null == node) {
            return 0;
        }
        return Math.max(height(node.getLeft()), height(node.getRight())) + 1;
    }
}
