import java.util.Scanner;

public class Slove {
    //ma trận lưu trữ kết quả
    private int[][] ans = new int[9][9];

    //get kết quả từ class khác
    public int[][] getAns() {
        return ans;
    }

    //gán kết quả
    public void returnSolution(int[][] S) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                if (S[i][j] == 0)
                    return;
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                ans[i][j] = S[i][j];
            }
        }
    }

    public boolean checkValid(int[][] S, int x, int y, int k) {
        for (int i = 0; i < 9; i++) {
            if (S[x][i] == k)
                return false;
        }
        for (int i = 0; i < 9; i++) {
            if (S[i][y] == k)
                return false;
        }
        int a = x / 3, b = y / 3;
        for (int i = 3 * a; i < 3 * a + 3; i++) {
            for (int j = 3 * b; j < 3 * b + 3; j++) {
                if (S[i][j] == k)
                    return false;
            }
        }
        return true;
    }

    public void TRY(int[][] S, int x, int y) {
        if (y == 9) {
            if (x == 8) {
                returnSolution(S);
            } else {
                TRY(S, x + 1, 0);
            }
        } else if (S[x][y] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (checkValid(S, x, y, i)) {
                    S[x][y] = i;
                    TRY(S, x, y + 1);
                    S[x][y] = 0;
                }
            }
        } else {
            TRY(S, x, y + 1);
        }
    }
}
