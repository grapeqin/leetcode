package github.grapeqin;

import java.util.ArrayList;
import java.util.List;

public class LeetCode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, left = 0, bottom = m - 1, right = n - 1;
        while (top <= bottom && left <= right) {
            //x轴从左到右
            for (int col = left; col <= right; col++) {
                System.out.println("x轴 matrix[" + top + "][" + col + "]");
                ans.add(matrix[top][col]);
            }
            //y轴从上到下
            for (int row = top + 1; row <= bottom; row++) {
                System.out.println("y轴 matrix[" + row + "][" + right + "]");
                ans.add(matrix[row][right]);
            }
            //x轴从右往左(注意x轴排除只遍历一轮的情况)
            for (int col = right - 1; col >= left && top < bottom; col--) {
                System.out.println("x轴 matrix[" + bottom + "][" + col + "]");
                ans.add(matrix[bottom][col]);
            }
            //y轴从下到上(注意y轴排除只遍历一轮的情况)
            for (int row = bottom - 1; row > top && left < right; row--) {
                System.out.println("y轴 matrix[" + row + "][" + left + "]");
                ans.add(matrix[row][left]);
            }
            top++;
            left++;
            bottom--;
            right--;
        }
        return ans;
    }
}
