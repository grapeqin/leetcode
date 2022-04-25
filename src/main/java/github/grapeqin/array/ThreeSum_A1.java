package github.grapeqin.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和: 排序+双指针解法,时间复杂度O(N^2)
 */
public class ThreeSum_A1 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        //取第一个数字
        for (int i = 0; i < nums.length - 2; i++) {
            //跳过第1个数字重复的情况
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            //双指针取第2和第3个数字
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k){
                int target = nums[i]+ nums[j]+nums[k];
                //符合条件的就加入结果集合
                if(0 == target){
                    //跳过第2个数重复的结果
                    while (j < k && nums[j] == nums[j+1]){
                        j++;
                    }
                    //跳过第3个数重复的结果
                    while (j < k && nums[k] == nums[k-1]){
                        k--;
                    }
                    resList.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }else if(target < 0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        List<List<Integer>> actualList = new ArrayList<>();
        actualList.add(Arrays.asList(-1,-1,2));
        actualList.add(Arrays.asList(-1,0,1));
        checkResult(new int[]{-1,0,1,2,-1,-4},actualList);

        actualList.clear();
        checkResult(new int[]{},actualList);

        actualList.clear();
        checkResult(new int[]{0},actualList);

        actualList.clear();
        actualList.add(Arrays.asList(-5,1,4));
        actualList.add(Arrays.asList(-4,0,4));
        actualList.add(Arrays.asList(-4,1,3));
        actualList.add(Arrays.asList(-2,-2,4));
        actualList.add(Arrays.asList(-2,1,1));
        actualList.add(Arrays.asList(0,0,0));
        checkResult(new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0},actualList);
    }

    private static void checkResult(int[] src,List<List<Integer>> actualList){
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
