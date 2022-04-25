package github.grapeqin.array;

import java.util.*;

/**
 * 三数之和：暴力解法,时间复杂度O(N^3)
 */
public class ThreeSum_A2 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> tmpList = new ArrayList<>();
        //三层遍历求结果
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (0 == nums[i] + nums[j] + nums[k]) {
                        List<Integer> set = new ArrayList<>(3);
                        set.add(nums[i]);
                        set.add(nums[j]);
                        set.add(nums[k]);
                        tmpList.add(set);
                    }
                }
            }
        }
        Set<List<Integer>> resSet = new HashSet<>();
        //T除重复结果
        for (List<Integer> list : tmpList) {
            Collections.sort(list);
            if(!resSet.contains(list)){
                resSet.add(list);
            }
        }
        List<List<Integer>> resList = new ArrayList<>();
        resSet.stream().forEach(o -> {
            resList.add(o);
        });
        return resList;
    }

    public static void main(String[] args) {
        List<List<Integer>> actualList = new ArrayList<>();
        actualList.add(Arrays.asList(-1, -1, 2));
        actualList.add(Arrays.asList(-1, 0, 1));
        checkResult(new int[]{-1, 0, 1, 2, -1, -4}, actualList);

        actualList.clear();
        checkResult(new int[]{}, actualList);

        actualList.clear();
        checkResult(new int[]{0}, actualList);

        actualList.clear();
        actualList.add(Arrays.asList(-5, 1, 4));
        actualList.add(Arrays.asList(-4, 0, 4));
        actualList.add(Arrays.asList(-4, 1, 3));
        actualList.add(Arrays.asList(-2, -2, 4));
        actualList.add(Arrays.asList(-2, 1, 1));
        actualList.add(Arrays.asList(0, 0, 0));
        checkResult(new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0}, actualList);
    }

    private static void checkResult(int[] src, List<List<Integer>> actualList) {
        List<List<Integer>> resList = threeSum(src);
        if(resList.size() != actualList.size()){
            throw new RuntimeException("程序运行失败!");
        }
        for(List<Integer> list : actualList){
            if(!resList.contains(list)){
                throw new RuntimeException("程序运行失败!");
            }
        }
    }
}
