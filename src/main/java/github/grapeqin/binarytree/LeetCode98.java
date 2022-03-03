package github.grapeqin.binarytree;

/**
 * 验证二叉搜索树
 * LeetCode98:https://leetcode.com/problems/validate-binary-search-tree/
 */
public class LeetCode98 {

    /**
     * 验证给定的二叉树是否二叉搜索树
     *
     * @param root
     * @return true:是二叉搜索树 false:不是二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 判断给定的一棵二叉树是否二叉搜索树
     * @param node 任一二叉树
     * @param min 最小值
     * @param max 最大值
     * @return true:是二叉搜索树,false:不是二叉搜索树
     */
    public boolean isValidBST(TreeNode node, long min, long max) {
        if (null == node) {
            return true;
        }
        if (min >= node.getVal() || max <= node.getVal()) {
            return false;
        }
        return isValidBST(node.getLeft(), min, node.getVal()) && isValidBST(node.getRight(), node.getVal(), max);
    }
}
