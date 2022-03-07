package github.grapeqin.binarytree;

/**
 * 求完全二叉树的节点个数
 */
public class LeetCode222 {

    /**
     * 递归求解,只要是二叉树都可以用该方法求解
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if(null == root){
            return 0;
        }
        return countNodes(root.getLeft()) + countNodes(root.getRight()) + 1;
    }

    /**
     * 经典解法,只需要遍历根节点的一棵子树即可得到结果
     * @param root
     * @return
     */
    public int countNodes1(TreeNode root) {
        if (null == root) {
            return 0;
        }
        //先判断根节点的左右子树谁是完全二叉树，谁是满二叉树
        int left = height(root.getLeft());
        int right = height(root.getRight());
        // 右子树是满二叉树,左子树是完全二叉树
        if (left == right) {
            return countNodes(root.getRight()) + (1 << left);
        } else {
            return countNodes(root.getLeft()) + (1 << right);
        }
    }

    /**
     * 完全二叉树的高度
     *
     * @param node
     * @return
     */
    public int height(TreeNode node) {
        int level = 0;
        while (null != node) {
            node = node.getLeft();
            level++;
        }
        return level;
    }
}