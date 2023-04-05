package github.grapeqin.binarytree;

/**
 * @description
 * @author qinzy
 * @date 2019-12-14
 */
public class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  private TreeNode() {}

  public TreeNode(int val) {
    this.val = val;
  }

  public int getVal() {
    return val;
  }

  public void setVal(int val) {
    this.val = val;
  }

  public TreeNode getLeft() {
    return left;
  }

  public void setLeft(TreeNode left) {
    this.left = left;
  }

  public TreeNode getRight() {
    return right;
  }

  public void setRight(TreeNode right) {
    this.right = right;
  }

  @Override
  public String toString() {
    return "TreeNode{" + "val=" + val + '}';
  }
}
