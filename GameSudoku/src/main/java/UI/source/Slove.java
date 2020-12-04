package UI.source;
import java.util.Scanner;

public class Slove {
    private int[][] ans = new int[9][9];

    public int[][] getAns() {
        return ans;
    }

    public void setAns(int[][] ans) {
        this.ans = ans;
    }

    public void sloveSudoku() {
        sudoku(ans);
    }

    public boolean sudoku(int[][] array) {
        int[] location = findNullLocation(array);

        //điều kiện dừng: toàn bộ ô được điền hết
        if (location[0] == -1)
            return true;

        //tạo bước xét tiếp theo
        int row = location[0];
        int col = location[1];

        for (int num = 1; num < 10; num++) {
            //kiểm tra num
            if (isSafe(array, row, col, num)) {

                //nếu num thoả mãn, gán
                array[row][col] = num;

                //quay lui trạng thái ô tiếp theo
                boolean check = sudoku(array);

                //điều kiện dừng
                if (check == true)
                    return true;

                //quay lui nếu chọn num là ngõ cụt
                array[row][col] = 0;
            }
        }

        return false;
    }

    public int[] findNullLocation(int[][] arr) {
        int[] location = new int[2]; //trả về ô chưa điền đầu tiên
        location[0] = -1;
        location[1] = -1;

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (arr[row][col] == 0) {
                    location[0] = row;
                    location[1] = col;
                    return location;
                }
            }
        }

        return location;
    }

    public boolean usedInRow(int[][] grid, int row, int num) {
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == num) {
                return true;
            }
        }
        return false;
    }

    public boolean usedIncol(int[][] grid, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (grid[i][col] == num) {
                return true;
            }
        }
        return false;
    }

    public boolean usedInBox(int[][] grid, int row1Start, int col1Start, int num) {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (grid[row + row1Start][col + col1Start] == num) {
                    return true;
                }
        return false;

    }

    public boolean isSafe(int[][] grid, int row, int col, int num) {
        return (!usedIncol(grid, col, num) && !usedInRow(grid, row, num) && !usedInBox(grid, row - row % 3, col - col % 3, num));
    }
    public boolean isSafe(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] != 0 && (usedInRow(grid, i, grid[i][j]) == true || usedIncol(grid, j, grid[i][j]) == true || usedInBox(grid, i - i % 3, j - j % 3, grid[i][j]) == true))
                    return false;
            }
        }
        return true;
    }
}
