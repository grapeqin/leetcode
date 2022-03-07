package github.grapeqin.binarytree;

/**
 * 二叉树的剪枝
 */
public class LeetCode814 {

    public TreeNode pruneTree(TreeNode root) {
        return prune(root);
    }

    public TreeNode prune(TreeNode node){
        if(null == node){
            return null;
        }
        //递归剪枝左右子树
        node.setLeft(prune(node.getLeft()));
        node.setRight(prune(node.getRight()));
        //这里要注意上面两行代码的位置,绝不能调换位置
        if(null==node.getLeft() && null == node.getRight() && 0 == node.getVal()){
            return null;
        }
        return node;
    }
}
