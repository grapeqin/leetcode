package github.grapeqin.binarytree;

/**
 * 二叉搜索树的查找
 */
public class LeetCode700 {

    /**
     * 从二叉搜索树中指定值的节点
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = root;
        while (null != node) {
            //目标值比当前节点值小，如果存在与目标值相等的节点，一定在左子树
            if (val < node.getVal()) {
                node = node.getLeft();
            //目标值比当前节点值大，如果存在与目标值相等的节点，一定在右子树
            } else if (val > node.getVal()) {
                node = node.getRight();
            } else {
            //目标值与当前节点值相等,直接返回
                return node;
            }
        }
        //二叉搜索树遍历完未找到相等的节点
        return null;
    }

}
