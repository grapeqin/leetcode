package github.grapeqin.binarytree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 二叉树的最近公共祖先
 */
public class LeetCode236 {
    Map<Integer, TreeNode> map = new HashMap<>();

    Set<TreeNode> visited = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //遍历并存储所有节点的父节点
        dfs(root);
        //遍历p节点,填充所有被访问的节点
        while (p != null) {
            visited.add(p);
            p = map.get(p.val);
        }
        //遍历q节点,一旦匹配被访问的节点,返回即可
        while (q != null) {
            if(visited.contains(q)){
                return q;
            }
            q = map.get(q.val);
        }
        return null;
    }

    private void dfs(TreeNode root) {
        if (null == root) {
            return;
        }
        if (null != root.left) {
            map.put(root.left.val, root);
            dfs(root.left);
        }
        if (null != root.right) {
            map.put(root.right.val, root);
            dfs(root.right);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}

