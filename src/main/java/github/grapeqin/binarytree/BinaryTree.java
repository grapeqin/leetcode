package github.grapeqin.binarytree;

/**
 * 通过数组构造二叉树
 *
 * @description
 * @author qinzy
 * @date 2019-12-14
 */
public class BinaryTree {

  private TreeNode root;

  public TreeNode getRoot() {
    return root;
  }

  public BinaryTree(Integer[] nums) {
    root = generateByArray(nums, 0);
  }

  public TreeNode generateByArray(Integer[] num, int index) {
    if (0 == num.length) {
      return null;
    }
    TreeNode tn = null;
    if (index < num.length) {
      Integer val = num[index];
      if (null == val) {
        return tn;
      }
      tn = new TreeNode(val);
      tn.setLeft(generateByArray(num, 2 * index + 1));
      tn.setRight(generateByArray(num, 2 * index + 2));
    }
    return tn;
  }

  public static void main(String[] args) {
    Integer[] array = new Integer[] {3, 9, 20, null, null, 15, 7};
    BinaryTree bt = new BinaryTree(array);
    System.out.println();
  }
}
