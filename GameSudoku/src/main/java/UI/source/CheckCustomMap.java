package UI.source;

import java.util.HashSet;
import java.util.Set;

public class CheckCustomMap {
    private int[][] input = new int[9][9];

    public int[][] getInput() {
        return input;
    }

    public void setInput(int[][] input) {
        this.input = input;
    }

    public int valid_row(int[][] grid, int row) {
        int temp[] = grid[row];
        Set<Integer>set = new HashSet<Integer>();
        for (int value : temp) {
            if (value < 0 || value > 9) {
                return -1;
            } else if (value != 0) {
                if (set.add(value) == false)
                    return 0;
            }
        }
        return 1;
    }

    public int valid_col(int[][] grid, int col) {
        Set<Integer>set = new HashSet<Integer>();
        for (int i = 0; i < 9; i++) {
            if (grid[i][col] < 0 || grid[i][col] > 9) {
                return -1;
            } else if (grid[i][col] != 0) {
                if (set.add(grid[i][col]) == false)
                    return 0;
            }
        }
        return 1;
    }

    public int valid_subsquares(int[][] grid) {
        for (int row = 0; row < 9; row = row + 3) {
            for (int col = 0; col < 9; col = col + 3) {
                Set<Integer>set = new HashSet<Integer>();
                for (int r = row; r < row + 3; r++) {
                    for (int c = col; c < col + 3; c++) {
                        if (grid[r][c] < 0 || grid[r][c] > 9)
                            return -1;
                        else if (grid[r][c] != 0)
                            if (set.add(grid[r][c]) == false)
                                return 0;
                    }
                }
            }
        }
        return 1;
    }

    public boolean valid_broad(int[][] grid) {
        for (int i =0 ; i< 9; i++) {
            int res1 = valid_row(grid, i);
            int res2 = valid_col(grid, i);
            if (res1 < 1 || res2 < 1) {
                return false;
            }
        }
        int res3 = valid_subsquares(grid);
        if (res3 < 1)
            return false;
        return true;
    }

    public boolean check_broad() {
        return valid_broad(input);
    }
}
