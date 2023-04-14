package github.grapeqin.binarytree;

import java.util.ArrayList;
import java.util.List;

public class LeetCode94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        dfs(root, ans);
        return ans;
    }

    private void dfs(TreeNode node, List<Integer> ans) {
        if (null == node) {
            return;
        }
        if (node.left != null) {
            dfs(node.left, ans);
        }
        ans.add(node.val);
        if (node.right != null) {
            dfs(node.right, ans);
        }
    }
}
