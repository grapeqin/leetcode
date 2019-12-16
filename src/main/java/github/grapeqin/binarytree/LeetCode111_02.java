package github.grapeqin.binarytree;

/**
 * 二叉树的最小深度
 *
 * <p>深度优先，找到所有子树的最小高度取最小值,第一个叶子节点的深度
 *
 * @description
 * @author qinzy
 * @date 2019-12-14
 */
public class LeetCode111_02 {

  public int minDepth(TreeNode root) {
    if (null == root) {
      return 0;
    }
    if (null == root.getLeft() && null == root.getRight()) {
      return 1;
    }
    int min = Integer.MAX_VALUE;
    if (null != root.getLeft()) {
      min = Math.min(minDepth(root.getLeft()), min);
    }
    if (null != root.getRight()) {
      min = Math.min(minDepth(root.getRight()), min);
    }
    return min + 1;
  }

  public static void main(String[] args) {
    Integer[] array = new Integer[] {3, 9, 20, null, null, 15, 7};
    BinaryTree bt = new BinaryTree(array);
    LeetCode111_02 leetCode111_02 = new LeetCode111_02();
    System.out.println(leetCode111_02.minDepth(bt.getRoot()));
  }
}
