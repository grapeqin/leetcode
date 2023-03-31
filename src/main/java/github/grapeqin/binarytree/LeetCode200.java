package github.grapeqin.binarytree;

import java.util.Arrays;

/**
 * 岛屿数量
 * DFS
 */
public class LeetCode200 {

    public int numIslands(char[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        System.out.println("rows = " + nr + ", cols = " + nc);
        int num = 0;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }

    private void dfs(char[][] grid, int i, int j) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (i >= nr || j >= nc || i < 0 || j < 0 || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {
        char[][] grid = new char[4][5];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(grid[i], '1');
        }
        grid[0][4] = '0';
        grid[1][2] = '0';
        grid[1][4] = '0';
        grid[2][2] = '0';
        grid[2][3] = '0';
        grid[2][4] = '0';
        grid[3][0] = '0';
        grid[3][1] = '0';
        grid[3][2] = '0';
        grid[3][3] = '0';

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(new LeetCode200().numIslands(grid));
    }
}
