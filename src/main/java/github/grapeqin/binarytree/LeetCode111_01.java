package github.grapeqin.binarytree;

import java.util.LinkedList;

/**
 * 二叉树的最小深度
 *
 * <p>广度优先搜索，第一个叶子节点的位置即为最小深度位置
 *
 * @description
 * @author qinzy
 * @date 2019-12-14
 */
public class LeetCode111_01 {

  public int minDepth(TreeNode root) {
    if (null == root) {
      return 0;
    }
    LinkedList<TreeNode> queue = new LinkedList<>();
    // 第一层结点入队列
    queue.add(root);
    int depth = 0;
    while (!queue.isEmpty()) {
      depth++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.remove();
        if (null == node.getLeft() && null == node.getRight()) {
          return depth;
        }
        if (null != node.getLeft()) {
          queue.add(node.getLeft());
        }
        if (null != node.getRight()) {
          queue.add(node.getRight());
        }
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    Integer[] array = new Integer[] {3, 9, 20, null, null, 15, 7};
    BinaryTree bt = new BinaryTree(array);
    LeetCode111_01 leetCode111_01 = new LeetCode111_01();
    System.out.println(leetCode111_01.minDepth(bt.getRoot()));
  }
}
