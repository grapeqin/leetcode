package github.grapeqin.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现LRU数据结构
 *
 * <p>哈希表+双向链表 get和put 时间复杂度为O(1)
 *
 * @description
 * @author qinzy
 * @date 2019-12-19
 */
public class LRUCache {

  /**
   * @param
   * @param
   */
  private static class LinkedNode {
    private int key;
    private int val;

    private LinkedNode prev;
    private LinkedNode next;
  }

  /** 头指针 */
  private LinkedNode head;

  /** 尾指针 */
  private LinkedNode tail;

  /** hash表的容量 */
  private int capacity;

  private Map<Integer, LinkedNode> container;

  public LRUCache(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("capacity must > 0");
    }
    this.capacity = capacity;
    container = new HashMap<>(capacity);
    head = new LinkedNode();
    tail = new LinkedNode();
    head.next = tail;
    tail.prev = head;
  }

  /**
   * 把当前结点移动到链表头部
   *
   * @param node
   */
  private void moveToHead(LinkedNode node) {
    delete(node);
    addToHead(node);
  }

  /**
   * 将结点插入到头部
   *
   * @param node
   */
  private void addToHead(LinkedNode node) {
    node.prev = head;
    node.next = head.next;

    head.next = node;
    node.next.prev = node;
  }

  /**
   * 删除当前结点
   *
   * @param node
   */
  private void delete(LinkedNode node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  public int get(int key) {
    LinkedNode node = container.get(key);
    if (null == node) {
      return -1;
    }
    moveToHead(node);
    return node.val;
  }

  public void put(int key, int value) {
    LinkedNode node = container.get(key);
    // 当前结构中不存在
    if (null == node) {
      // 如果当前容量已经超限
      if (container.size() >= capacity) {
        node = tail.prev;
        container.remove(node.key);
        delete(node);
      }

      node = new LinkedNode();
      node.val = value;
      node.key = key;
      container.put(key, node);
      addToHead(node);
    } else {
      node.val = value;
      moveToHead(node);
    }
  }

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println("cache.get(1) = " + cache.get(1));
    cache.put(3, 3);
    System.out.println("cache.get(2) = " + cache.get(2));
    cache.put(4, 4);
    System.out.println("cache.get(1) = " + cache.get(1));
    System.out.println("cache.get(3) = " + cache.get(3));
    System.out.println("cache.get(4) = " + cache.get(4));
  }
}
