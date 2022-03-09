package github.grapeqin.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后问题
 */
public class LeetCode51 {

    private int[] pos;

    public List<List<String>> solveNQueens(int n) {
        //存放结果
        List<List<String>> res = new ArrayList<>();
        //声明一个数组,下标表示第i行,pos[i]的值为放置皇后的列
        pos = new int[n];
        fill(0,res);
        return res;
    }

    public void fill(int row,List<List<String>> res){
        if(row == pos.length){
            //表示每行都放完了,保存结果
            print(res);
            return;
        }
        for (int j = 0; j < pos.length; j++) {
            //判断(row,j)位置是否能放置Queen
            if(isOk(row,j)){
                pos[row] = j;
                fill(row+1,res);
            }
        }
    }

    /**
     * 指定位置是否可以放置皇后
     * @param row
     * @param col
     * @return
     */
    public boolean isOk(int row,int col){
        int leftup = col - 1;
        int rightup = col + 1;
        for (int i = row - 1; i >= 0; i--) {
            //表示同一列上存在皇后
            if(pos[i] == col){
                return false;
            }
            //表示左上角对角线存在皇后
            if(leftup >= 0 && pos[i] == leftup){
                return false;
            }
            //表示右上角对角线存在皇后
            if(rightup < pos.length && pos[i] == rightup){
                return false;
            }
            leftup--;
            rightup++;
        }
        return true;
    }

    public void print(List<List<String>> res){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < pos.length; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < pos.length; j++) {
                if(pos[i] == j){
                    row.append("Q");
                }else{
                    row.append(". ");
                }
            }
            list.add(row.toString());
        }
        res.add(list);
    }

    public static void main(String[] args) {
        LeetCode51 leetCode51 = new LeetCode51();

        int n = 1;
        System.out.println("n = " + n);
        List<List<String>> resList = leetCode51.solveNQueens(n);
        resList.forEach((list) -> {
            list.forEach((row) ->{
                System.out.println(row);
            });
            System.out.println();
        });

        n = 2;
        System.out.println("n = " + n);
        resList = leetCode51.solveNQueens(n);
        resList.forEach((list) -> {
            list.forEach((row) ->{
                System.out.println(row);
            });
            System.out.println();
        });

        n = 3;
        System.out.println("n = " + n);
        resList = leetCode51.solveNQueens(n);
        resList.forEach((list) -> {
            list.forEach((row) ->{
                System.out.println(row);
            });
            System.out.println();
        });

        n = 4;
        System.out.println("n = " + n);
        resList = leetCode51.solveNQueens(n);
        resList.forEach((list) -> {
            list.forEach((row) ->{
                System.out.println(row);
            });
            System.out.println();
        });
    }
}
