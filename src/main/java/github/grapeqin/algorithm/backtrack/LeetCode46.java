package github.grapeqin.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS + 回溯算法
 */
public class LeetCode46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int n = nums.length;
        if (n == 0) {
            return ans;
        }

        List<Integer> res = new ArrayList<>();
        boolean[] used = new boolean[n];
        dfs(nums, n, 0, res, used, ans);
        return ans;
    }

    private void dfs(int[] nums, int n, int index, List<Integer> res, boolean[] used, List<List<Integer>> ans) {
        if (index == n) {
            //添加结果集,注意要拷贝集合
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                res.add(nums[i]);
                used[i] = true;

                dfs(nums, n, index + 1, res, used, ans);
                //还原状态
                res.remove(res.size() - 1);
                used[i] = false;
            }
        }
    }
}
