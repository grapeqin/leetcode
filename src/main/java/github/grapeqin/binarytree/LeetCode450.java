package github.grapeqin.binarytree;

/**
 * 二叉搜索树的删除
 */
public class LeetCode450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        //存储待删除节点的父节点
        TreeNode pp = null;
        //存储待删除节点
        TreeNode p = root;

        //1.查找待删除的节点
        while (null != p && key != p.getVal()) {
            pp = p;
            if (key < p.getVal()) {
                p = p.getLeft();
            } else {
                p = p.getRight();
            }
        }

        //二叉搜索树中不存在待删除的节点
        if (null == p) {
            return root;
        }

        //待删除节点有2个子节点的情况,找到待删除节点右子树上的最小节点
        if (null != p.getLeft() && null != p.getRight()) {
            TreeNode minPP = p;
            TreeNode minP = p.getRight();
            while (null != minP && null != minP.getLeft()) {
                minPP = minP;
                minP = minP.getLeft();
            }
            //用右子树最小节点的值覆盖待删除节点
            p.setVal(minP.getVal());
            p = minP;
            pp = minPP;
        }

        //保存待删除节点的子节点
        TreeNode child = null;
        if (null != p.getLeft()) {
            child = p.getLeft();
        } else if (null != p.getRight()) {
            child = p.getRight();
        }

        // 表示删除根节点
        if (null == pp) {
            root = child;
            // pp的左子节点等于p,则让pp的左子节点指针指向child节点
        } else if (p == pp.getLeft()) {
            pp.setLeft(child);
            // pp的右子节点等于p,则让pp的右子节点指针指向child节点
        } else if (p == pp.getRight()) {
            pp.setRight(child);
        }
        return root;
    }

}
