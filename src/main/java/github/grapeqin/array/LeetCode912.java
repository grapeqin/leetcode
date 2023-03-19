package github.grapeqin.array;

import java.util.Random;

/**
 * 排序数组
 */
public class LeetCode912 {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int pos = partition(nums, l, r);
        quickSort(nums, l, pos - 1);
        quickSort(nums, pos + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        //随机选择参考值
        int p = new Random().nextInt(r - l + 1) + l;
        swap(nums, p, r);
        int pivot = nums[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, r);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
