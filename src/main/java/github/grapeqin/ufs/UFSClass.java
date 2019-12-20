package github.grapeqin.ufs;

/**
 * 并查集
 *
 * @description
 * @author qinzy
 * @date 2019-12-20
 */
public class UFSClass {

  private int[] roots;

  /**
   * 初始化
   *
   * @param n
   */
  public UFSClass(int n) {
    roots = new int[n];
    for (int i = 0; i < n; i++) {
      roots[i] = i;
    }
  }

  /**
   * 查找数据的上级结点
   *
   * @param n
   * @return
   */
  public int findRoot(int n) {
    int root = n;
    while (root != roots[root]) {
      root = roots[root];
    }
    // 并查集优化(路径压缩)
    int i = n;
    while (i != roots[i]) {
      int tmp = roots[i];
      roots[i] = root;
      i = tmp;
    }
    return root;
  }

  /**
   * 判断两个数是否属于同一个集合
   *
   * @param p
   * @param q
   * @return
   */
  public boolean connected(int p, int q) {
    return findRoot(p) == findRoot(q);
  }

  /**
   * 数据集合并
   *
   * @param p
   * @param q
   */
  public void union(int p, int q) {
    int pRoot = findRoot(p);
    int qRoot = findRoot(q);
    roots[pRoot] = qRoot;
  }
}
