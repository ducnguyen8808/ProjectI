public class Slove {
    private int[][] array = new int[9][9];

    public int[][] getArray() {
        return array;
    }

    public void setArray(int[][] array) {
        this.array = array;
    }

    public void printSolution(int[][] S) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(S[i][j] + " ");
            }
            System.out.println(S[i][8]);
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

    public void sloveSudoku(int[][] S, int x, int y) {
        if (y == 9) {
            if (x == 8) {
                printSolution(S);
                System.exit(0);
            } else {
                sloveSudoku(S, x + 1, 0);
            }
        } else if (S[x][y] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (checkValid(S, x, y, i)) {
                    S[x][y] = i;
                    sloveSudoku(S, x, y + 1);
                    S[x][y] = 0;
                }
            }
        } else {
            sloveSudoku(S, x, y + 1);
        }
    }


}
