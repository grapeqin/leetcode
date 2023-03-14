package github.grapeqin.array;

import java.util.PriorityQueue;

/**
 * 数组中第k个最大元素
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/
 */
public class LeetCode215 {

    /**
     * 采用堆数据结构来处理，时间复杂度为O(NlogK)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestByDump(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int n : nums) {
            queue.add(n);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

    /**
     * 采用快速选择算法，平均时间复杂度为O(N)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        int n = nums.length;
        while( l < r ) {
            int idx = partition(nums,l,r);
            if(idx == n - k){
                return nums[idx];
            }else if(idx < n - k) {
                l = idx + 1;
            }else {
                r = idx - 1;
            }
        }
        return nums[l];
    }

    /**
     * 给定数组及其起止边界并返回指定idx前后排序的数组
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private int partition(int[] nums, int l, int r) {
        // 选择最后一个位置的元素作为参考值
        int pivot = nums[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if(nums[j] < pivot){
                //交换元素
                swap(nums,i,j);
                i++;
            }
        }
        //交换参考值
        swap(nums,i,r);
        return i;
    }

    private void swap(int[] nums,int l,int r){
        if(l != r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
    }
}
